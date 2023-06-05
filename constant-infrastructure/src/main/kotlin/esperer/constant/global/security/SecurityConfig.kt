package esperer.constant.global.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
class SecurityConfig {
    @Bean
    protected fun passwordEncoder() = BCryptPasswordEncoder()
}