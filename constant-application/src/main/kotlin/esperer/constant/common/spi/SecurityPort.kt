package esperer.constant.common.spi

import java.util.*

interface SecurityPort {

    fun isPasswordMatch(rawPassword: String, encodedPassword: String): Boolean

    fun isAuthenticated(): Boolean

    fun getCurrentUserId(): UUID

    fun encodePassword(password: String): String

}