package esperer.constant.domain.sprint.service

import esperer.constant.domain.sprint.model.Sprint

interface CommandSprintService {
    fun save(sprint: Sprint): Sprint
}