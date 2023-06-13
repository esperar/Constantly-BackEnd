package esperer.constant.domain.user.service

import esperer.constant.domain.user.model.User
import java.util.UUID

interface QueryUserService {
    fun queryUserById(id: UUID): User
    fun queryUserByEmail(email: String): User
    fun getCurrentUser(): User
}