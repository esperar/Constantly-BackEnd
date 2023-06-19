package esperer.constant.domain.auth.usecase

import esperer.constant.common.annotation.UseCase
import esperer.constant.common.service.SecurityService
import esperer.constant.domain.auth.dto.request.SignUpRequest
import esperer.constant.domain.auth.dto.response.TokenResponse
import esperer.constant.domain.auth.model.Authority
import esperer.constant.domain.auth.spi.JwtPort
import esperer.constant.domain.user.exception.EmailAlreadyExistsException
import esperer.constant.domain.user.model.User
import esperer.constant.domain.user.service.UserService
import java.util.*

@UseCase
class SignUpUseCase(
    private val userService: UserService,
    private val securityService: SecurityService,
    private val jwtPort: JwtPort
) {

    fun execute(request: SignUpRequest): TokenResponse{

        if(userService.existsByEmail(request.email))
            throw EmailAlreadyExistsException

        val user = userService.save(
            User(
                id = UUID.randomUUID(),
                email = request.email,
                password = securityService.encodePassword(request.password),
                name = request.name,
                profileFileName = request.profileFileName ?: "",
                authority = Authority.ROLE_USER,
                sprintId = null
            )
        )

        return jwtPort.receiveToken(
            user.id,
            Authority.ROLE_USER
        )
    }
}