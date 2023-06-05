package esperer.constant.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import esperer.constant.global.filter.FilterConfig
import esperer.constant.global.security.handler.CustomAccessDenied
import esperer.constant.global.security.handler.CustomAuthenticationEntryPoint
import esperer.constant.global.security.token.JwtParser
import esperer.constant.global.security.token.JwtProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig(
    private val jwtParser: JwtParser,
    private val objectMapper: ObjectMapper,
    private val customAuthenticationEntryPoint: CustomAuthenticationEntryPoint,
    private val customAccessDenied: CustomAccessDenied
) {
    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf().disable()
            .cors().and()

        http
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http
            .authorizeRequests()
            .requestMatchers(HttpMethod.GET, "/").permitAll()
            .anyRequest().denyAll()

        http.apply(FilterConfig(jwtParser, objectMapper))

        http.exceptionHandling()
            .authenticationEntryPoint(customAuthenticationEntryPoint)
            .accessDeniedHandler(customAccessDenied)

        return http.build()
    }

    @Bean
    protected fun passwordEncoder() = BCryptPasswordEncoder()
}