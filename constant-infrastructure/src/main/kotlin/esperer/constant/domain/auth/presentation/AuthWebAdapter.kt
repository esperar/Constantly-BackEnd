package esperer.constant.domain.auth.presentation

import esperer.constant.domain.auth.dto.request.SignUpRequest
import esperer.constant.domain.auth.presentation.dto.request.SignUpWebRequest
import esperer.constant.domain.auth.usecase.SignUpUseCase
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Validated
@RestController
@RequestMapping("/auth")
class AuthWebAdapter(
    private val signUpUseCase: SignUpUseCase
) {

    @PostMapping
    fun signUp(@RequestBody @Valid request: SignUpWebRequest){
        signUpUseCase.execute(
            SignUpRequest(
                email = request.email,
                password = request.password,
                name = request.name,
                profileFileName = request.profileFileName
            )
        )
    }

}