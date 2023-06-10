package esperer.constant.domain.user.service

import esperer.constant.domain.user.model.User
import esperer.constant.domain.user.spi.CommandUserPort

class CommandUserService(
    private val commandUserPort: CommandUserPort
) {

    fun save(user: User): User =
        commandUserPort.save(user)
}