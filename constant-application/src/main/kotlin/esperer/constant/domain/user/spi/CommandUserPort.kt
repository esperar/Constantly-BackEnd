package esperer.constant.domain.user.spi

import esperer.constant.domain.user.model.User

interface CommandUserPort {

    fun save(user: User): User
}