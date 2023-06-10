package esperer.constant.domain.auth.presentation.dto.request

import jakarta.validation.constraints.NotBlank

data class SignUpWebRequest(
    @field:NotBlank
    val email: String,
    @field:NotBlank
    val password: String,
    @field:NotBlank
    val name: String,
    val profileFileName: String?
)
