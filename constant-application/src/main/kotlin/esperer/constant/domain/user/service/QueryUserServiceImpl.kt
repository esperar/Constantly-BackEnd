package esperer.constant.domain.user.service

import esperer.constant.common.annotation.Service
import esperer.constant.common.service.SecurityService
import esperer.constant.domain.user.exception.UserNotFoundException
import esperer.constant.domain.user.spi.QueryUserPort
import java.util.UUID

@Service
class QueryUserServiceImpl(
    private val queryUserPort: QueryUserPort,
    private val securityService: SecurityService
) : QueryUserService{

    override fun queryUserById(id: UUID) =
        queryUserPort.queryUserById(id) ?: throw UserNotFoundException

    override fun queryUserByEmail(email: String) =
        queryUserPort.queryUserByEmail(email) ?: throw UserNotFoundException

    override fun getCurrentUser() =
        queryUserById(securityService.getCurrentUserId())
}