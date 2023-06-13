package esperer.constant.domain.sprint.usecase

import esperer.constant.common.annotation.UseCase
import esperer.constant.domain.sprint.dto.request.CreateSprintRequest
import esperer.constant.domain.sprint.model.Sprint
import esperer.constant.domain.sprint.model.SprintStatus
import esperer.constant.domain.sprint.service.CommandSprintServiceImpl
import esperer.constant.domain.sprint.service.SprintService
import esperer.constant.domain.user.service.CommandUserServiceImpl
import esperer.constant.domain.user.service.QueryUserServiceImpl
import esperer.constant.domain.user.service.UserService
import java.util.*

@UseCase
class CreateSprintUseCase(
    private val userService: UserService,
    private val sprintService: SprintService
) {

    fun execute(request: CreateSprintRequest){

        val user = userService.getCurrentUser()

        val sprint = sprintService.save(
            Sprint(
                id = UUID.randomUUID(),
                title = request.title,
                target = request.target,
                sprintStatus = SprintStatus.BEFORE_START,
                startDate = request.startDate,
                endDate = request.endDateTime
            )
        )

        userService.save(user.copy(sprintId = sprint.id))
    }
}