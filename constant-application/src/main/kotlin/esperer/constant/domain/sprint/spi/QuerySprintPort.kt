package esperer.constant.domain.sprint.spi

import java.util.UUID

interface QuerySprintPort {

    fun querySprintById(id: UUID)
}