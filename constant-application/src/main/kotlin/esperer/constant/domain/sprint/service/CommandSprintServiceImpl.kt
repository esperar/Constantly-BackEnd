package esperer.constant.domain.sprint.service

import esperer.constant.common.annotation.Service
import esperer.constant.domain.sprint.model.Sprint
import esperer.constant.domain.sprint.spi.CommandSprintPort

@Service
class CommandSprintServiceImpl(
    private val commandSprintPort: CommandSprintPort
) : CommandSprintService {

    override fun save(sprint: Sprint): Sprint =
        commandSprintPort.save(sprint)
}