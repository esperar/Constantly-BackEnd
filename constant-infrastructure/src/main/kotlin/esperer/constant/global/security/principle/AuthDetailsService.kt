package esperer.constant.global.security.principle

import esperer.constant.domain.user.mapper.UserMapper
import esperer.constant.domain.user.port.QueryUserPort
import esperer.constant.global.security.exception.InvalidTokenException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.util.*

@Component
class AuthDetailsService(
    private val queryUserPort: QueryUserPort,
    private val userMapper: UserMapper
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = queryUserPort.queryUserById(UUID.fromString(username))
            ?: throw InvalidTokenException

        return AuthDetails(
            userMapper.toEntity(user)
        )
    }
}