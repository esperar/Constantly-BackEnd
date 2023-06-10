package esperer.constant.domain.auth.dto.request

data class SignUpRequest(
    val email: String,
    val password: String,
    val name: String,
    val profileFileName: String?
)
