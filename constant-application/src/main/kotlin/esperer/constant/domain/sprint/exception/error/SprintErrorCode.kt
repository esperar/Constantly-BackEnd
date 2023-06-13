package esperer.constant.domain.sprint.exception.error

import esperer.constant.common.error.ErrorProperty

enum class SprintErrorCode(
    private val message: String,
    private val status: Int
) : ErrorProperty {
    SPRINT_NOT_FOUND("Sprint Not Found", 404)
    ;

    override fun status(): Int = status

    override fun message(): String = message
}