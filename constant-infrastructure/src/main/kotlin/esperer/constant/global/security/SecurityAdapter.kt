package esperer.constant.global.security

import esperer.constant.common.spi.SecurityPort
import esperer.constant.global.security.principle.AuthDetails
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.util.*

@Component
class SecurityAdapter(
    private val passwordEncoder: PasswordEncoder
) : SecurityPort {

    override fun isPasswordMatch(rawPassword: String, encodedPassword: String): Boolean =
        passwordEncoder.matches(rawPassword, encodedPassword)

    override fun isAuthenticated(): Boolean =
        SecurityContextHolder.getContext().authentication.principal is AuthDetails

    override fun getCurrentUserId(): UUID =
        UUID.fromString(SecurityContextHolder.getContext().authentication.name)

    override fun encodePassword(password: String): String =
        passwordEncoder.encode(password)
}