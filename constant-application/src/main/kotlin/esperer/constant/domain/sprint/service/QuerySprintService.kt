package esperer.constant.domain.sprint.service

import esperer.constant.domain.sprint.model.Sprint
import java.util.UUID

interface QuerySprintService {
    fun querySprintById(id: UUID): Sprint
    fun queryAllSprint(): List<Sprint>
}