package esperer.constant.domain.sprint.presentation.dto.request

import java.time.LocalDateTime

data class CreateSprintWebRequest(
    val title: String,
    val target: String,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime
)
