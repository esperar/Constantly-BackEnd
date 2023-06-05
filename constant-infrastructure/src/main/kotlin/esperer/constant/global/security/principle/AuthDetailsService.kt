package esperer.constant.global.security.principle

import esperer.constant.domain.user.port.QueryUserPort
import org.springframework.stereotype.Component

@Component
class AuthDetailsService(
    private val queryUserPort: QueryUserPort
) {
}