package esperer.constant.domain.user.service

import esperer.constant.common.annotation.Service
import esperer.constant.domain.user.spi.CheckUserPort

@Service
class CheckUserServiceImpl(
    private val checkUserPort: CheckUserPort
) : CheckUserService {

    override fun existsByEmail(email: String): Boolean =
        checkUserPort.existsByEmail(email)
}