package esperer.constant.domain.sprint.usecase

import esperer.constant.common.annotation.ReadOnlyUseCase
import esperer.constant.domain.sprint.dto.response.SprintResponse
import esperer.constant.domain.sprint.dto.response.SprintsResponse
import esperer.constant.domain.sprint.service.SprintService

@ReadOnlyUseCase
class QueryAllSprintUseCase(
    private val sprintService: SprintService
) {

    fun execute(): SprintsResponse {
        val sprints = sprintService.queryAllSprint()

        return SprintsResponse(
            sprints.map {
                SprintResponse.of(it)
            }
        )
    }

}