package esperer.constant.domain.auth.usecase

import esperer.constant.common.annotation.UseCase
import esperer.constant.domain.auth.dto.request.SignInRequest
import esperer.constant.domain.auth.model.Authority
import esperer.constant.domain.user.model.User
import esperer.constant.domain.user.spi.CommandUserPort
import java.util.*

@UseCase
class SignUpUseCase(
    private val commandUserPort: CommandUserPort
) {

    fun execute(request: SignInRequest){

        val user = User(
            id = UUID.randomUUID(),
            email = request.email,
            password = request.password,
            name = request.name,
            profileFileName = request.profileFileName ?: "",
            authority = Authority.ROLE_USER
        )

        commandUserPort.save(user)
    }
}