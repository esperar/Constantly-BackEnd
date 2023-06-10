package esperer.constant.domain.user.service

import esperer.constant.common.spi.SecurityPort
import esperer.constant.domain.user.exception.UserNotFoundException
import esperer.constant.domain.user.spi.QueryUserPort
import java.util.UUID

class QueryUserService(
    private val queryUserPort: QueryUserPort,
    private val securityPort: SecurityPort
) {

    fun queryUserById(id: UUID) =
        queryUserPort.queryUserById(id) ?: throw UserNotFoundException

    fun getCurrentUser() =
        queryUserById(securityPort.getCurrentUserId())
}