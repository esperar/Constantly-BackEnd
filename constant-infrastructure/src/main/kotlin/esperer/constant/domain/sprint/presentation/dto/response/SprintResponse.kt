package esperer.constant.domain.sprint.presentation.dto.response

import esperer.constant.domain.sprint.model.Sprint
import esperer.constant.domain.user.model.User
import java.time.LocalDateTime
import java.util.*

data class SprintResponse(
    val id: UUID,
    val title: String,
    val target: String? = null,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
    val user: User? = null
) {
    companion object {
        fun of(sprint: Sprint): SprintResponse{
            return SprintResponse(
                id = sprint.id,
                title = sprint.title,
                startDate = sprint.startDate,
                endDate = sprint.endDate,
            )
        }

        fun detailOf(sprint: Sprint, user: User): SprintResponse{
            return SprintResponse(
                id = sprint.id,
                title = sprint.title,
                target = sprint.target,
                startDate = sprint.startDate,
                endDate = sprint.endDate,
                user = user
            )
        }
    }
}

data class SprintsResponse(
    val sprints: List<SprintResponse>
)

data class SprintIdResponse(
    val sprintId: UUID
)