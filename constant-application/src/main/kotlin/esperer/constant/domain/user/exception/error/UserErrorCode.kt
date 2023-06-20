package esperer.constant.domain.user.exception.error

import esperer.constant.common.error.ErrorProperty

enum class UserErrorCode(
    private val status: Int,
    private val message: String
) : ErrorProperty {

    USER_NOT_FOUND(404, "User Not Found.."),
    EMAIL_ALREADY_EXISTS(409, "Already Exists Email..")
    ;

    override fun status(): Int = status
    override fun message(): String = message
}