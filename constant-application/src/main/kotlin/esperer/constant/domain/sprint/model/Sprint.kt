package esperer.constant.domain.sprint.model

import esperer.constant.common.annotation.Aggregate
import java.time.LocalDateTime
import java.util.UUID

@Aggregate
data class Sprint(
    val id: UUID,
    val title: String,
    val target: String,
    val sprintStatus: SprintStatus,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime
)
