package esperer.constant.domain.sprint.spi

import esperer.constant.domain.sprint.model.Sprint
import java.util.UUID

interface QuerySprintPort {

    fun querySprintById(id: UUID): Sprint?
}