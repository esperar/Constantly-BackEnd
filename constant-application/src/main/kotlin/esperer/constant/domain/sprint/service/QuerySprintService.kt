package esperer.constant.domain.sprint.service

import esperer.constant.common.annotation.Service
import esperer.constant.domain.sprint.model.Sprint
import esperer.constant.domain.sprint.spi.QuerySprintPort
import java.util.UUID

@Service
class QuerySprintService(
    private val querySprintPort: QuerySprintPort
) {

    fun querySprintById(id: UUID): Sprint? =
        querySprintPort.querySprintById(id)
}