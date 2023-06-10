package esperer.constant.domain.auth.presentation

import esperer.constant.domain.auth.usecase.SignUpUseCase
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthWebAdapter(
    private val signUpUseCase: SignUpUseCase
) {


}