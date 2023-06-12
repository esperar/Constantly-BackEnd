package esperer.constant.domain.sprint.spi

import esperer.constant.domain.sprint.model.Sprint

interface CommandSprintPort {

    fun save(sprint: Sprint): Sprint
}