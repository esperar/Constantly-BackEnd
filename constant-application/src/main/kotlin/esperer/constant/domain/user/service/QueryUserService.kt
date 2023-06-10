package esperer.constant.domain.user.service

import esperer.constant.common.service.SecurityService
import esperer.constant.common.spi.SecurityPort
import esperer.constant.domain.user.exception.UserNotFoundException
import esperer.constant.domain.user.spi.QueryUserPort
import java.util.UUID

class QueryUserService(
    private val queryUserPort: QueryUserPort,
    private val securityService: SecurityService
) {

    fun queryUserById(id: UUID) =
        queryUserPort.queryUserById(id) ?: throw UserNotFoundException

    fun getCurrentUser() =
        queryUserById(securityService.getCurrentUserId())
}