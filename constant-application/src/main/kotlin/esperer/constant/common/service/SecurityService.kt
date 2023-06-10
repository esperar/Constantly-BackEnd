package esperer.constant.common.service

import esperer.constant.common.spi.SecurityPort
import java.util.*

class SecurityService(
    private val securityPort: SecurityPort
) {

    fun isPasswordMatch(rawPassword: String, encodedPassword: String): Boolean =
        securityPort.isPasswordMatch(rawPassword, encodedPassword)

    fun isAuthenticated(): Boolean =
        securityPort.isAuthenticated()

    fun getCurrentUserId(): UUID =
        securityPort.getCurrentUserId()

    fun encodePassword(password: String): String =
        securityPort.encodePassword(password)
}