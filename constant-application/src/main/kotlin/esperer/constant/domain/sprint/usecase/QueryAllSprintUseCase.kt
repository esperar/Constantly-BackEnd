package esperer.constant.domain.sprint.usecase

import esperer.constant.common.annotation.ReadOnlyUseCase
import esperer.constant.domain.sprint.service.SprintService
import esperer.constant.domain.user.service.UserService

@ReadOnlyUseCase
class QueryAllSprintUseCase(
    private val sprintService: SprintService,
    private val userService: UserService
) {


}