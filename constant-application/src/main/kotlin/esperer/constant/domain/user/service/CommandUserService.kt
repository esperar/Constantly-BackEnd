package esperer.constant.domain.user.service

import esperer.constant.domain.user.model.User

interface CommandUserService {
    fun save(user: User): User
}