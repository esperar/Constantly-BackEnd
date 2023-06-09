package esperer.constant.domain.sprint.service

import esperer.constant.common.annotation.Service
import esperer.constant.domain.sprint.exception.SprintNotFoundException
import esperer.constant.domain.sprint.model.Sprint
import esperer.constant.domain.sprint.spi.QuerySprintPort
import java.util.UUID

@Service
class QuerySprintServiceImpl(
    private val querySprintPort: QuerySprintPort
) : QuerySprintService {

    override fun querySprintById(id: UUID): Sprint =
        querySprintPort.querySprintById(id) ?: throw SprintNotFoundException

    override fun queryAllSprint(): List<Sprint> =
        querySprintPort.queryAllSprint()

}