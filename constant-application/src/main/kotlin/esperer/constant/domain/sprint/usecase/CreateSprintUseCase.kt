package esperer.constant.domain.sprint.usecase

import esperer.constant.common.annotation.UseCase
import esperer.constant.domain.sprint.dto.request.CreateSprintRequest
import esperer.constant.domain.sprint.model.Sprint
import esperer.constant.domain.sprint.model.SprintStatus
import esperer.constant.domain.sprint.service.CommandSprintService
import esperer.constant.domain.user.service.CommandUserService
import esperer.constant.domain.user.service.QueryUserService
import java.util.*

@UseCase
class CreateSprintUseCase(
    private val commandSprintService: CommandSprintService,
    private val queryUserService: QueryUserService,
    private val commandUserService: CommandUserService
) {

    fun execute(request: CreateSprintRequest){

        val user = queryUserService.getCurrentUser()

        val sprint = commandSprintService.save(
            Sprint(
                id = UUID.randomUUID(),
                title = request.title,
                target = request.target,
                sprintStatus = SprintStatus.BEFORE_START,
                startDate = request.startDate,
                endDate = request.endDateTime
            )
        )

        commandUserService.save(user.copy(sprintId = sprint.id))
    }
}