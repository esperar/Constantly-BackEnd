package esperer.constant.domain.user.port

import esperer.constant.domain.user.model.User
import java.util.*

interface QueryUserPort {
    fun queryUserById(id: UUID): User?
}