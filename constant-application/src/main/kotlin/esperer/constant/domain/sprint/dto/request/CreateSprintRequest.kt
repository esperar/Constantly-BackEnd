package esperer.constant.domain.sprint.dto.request

import java.time.LocalDateTime

data class CreateSprintRequest(
    val title: String,
    val target: String,
    val startDate: LocalDateTime,
    val endDateTime: LocalDateTime
)
