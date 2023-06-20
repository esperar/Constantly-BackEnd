package esperer.constant.domain.user.spi

interface CheckUserPort {

    fun existsByEmail(email: String): Boolean
}