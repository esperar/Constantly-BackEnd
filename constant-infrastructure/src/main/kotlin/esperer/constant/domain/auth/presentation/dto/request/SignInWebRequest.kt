package esperer.constant.domain.auth.presentation.dto.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class SignInWebRequest(
    @field:Email
    val email: String,
    @field:NotBlank
    val password: String
)
