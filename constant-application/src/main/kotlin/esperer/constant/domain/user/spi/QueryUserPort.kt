package esperer.constant.domain.user.spi

import esperer.constant.domain.sprint.model.Sprint
import esperer.constant.domain.user.model.User
import java.util.*

interface QueryUserPort {
    fun queryUserById(id: UUID): User?
    fun queryUserByEmail(email: String): User?
    fun queryAllUserBySprint(sprint: Sprint): List<User>
}