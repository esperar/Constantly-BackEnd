package esperer.constant.domain.auth.usecase

import esperer.constant.common.annotation.ReadOnlyUseCase
import esperer.constant.common.service.SecurityService
import esperer.constant.domain.auth.dto.request.SignInRequest
import esperer.constant.domain.auth.dto.response.TokenResponse
import esperer.constant.domain.auth.spi.JwtPort
import esperer.constant.domain.user.service.QueryUserService

@ReadOnlyUseCase
class SignInUseCase(
    private val securityService: SecurityService,
    private val queryUserService: QueryUserService,
    private val jwtPort: JwtPort
) {

    fun execute(request: SignInRequest): TokenResponse{
        val user = queryUserService.queryUserByEmail(request.email)

        securityService.isPasswordMatch(request.password, user.password)

        return jwtPort.receiveToken(user.id, user.authority)
    }
}