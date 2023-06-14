package esperer.constant.domain.sprint.usecase

import esperer.constant.common.annotation.ReadOnlyUseCase
import esperer.constant.domain.sprint.service.SprintService

@ReadOnlyUseCase
class QueryAllSprintUseCase(
    private val sprintService: SprintService
) {
}