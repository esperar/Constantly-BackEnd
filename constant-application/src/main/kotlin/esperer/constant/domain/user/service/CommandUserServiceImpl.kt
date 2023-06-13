package esperer.constant.domain.user.service

import esperer.constant.common.annotation.Service
import esperer.constant.domain.user.model.User
import esperer.constant.domain.user.spi.CommandUserPort

@Service
class CommandUserServiceImpl(
    private val commandUserPort: CommandUserPort
) : CommandUserService {

    override fun save(user: User): User =
        commandUserPort.save(user)
}