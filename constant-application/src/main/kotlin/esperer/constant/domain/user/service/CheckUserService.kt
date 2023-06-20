package esperer.constant.domain.user.service

interface CheckUserService {
    fun existsByEmail(email: String): Boolean
}