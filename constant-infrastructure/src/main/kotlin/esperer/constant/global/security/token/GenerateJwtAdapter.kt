package esperer.constant.global.security.token

import esperer.constant.domain.auth.dto.response.TokenResponse
import esperer.constant.domain.auth.model.Authority
import esperer.constant.domain.auth.model.RefreshToken
import esperer.constant.domain.auth.spi.CommandRefreshTokenPort
import esperer.constant.domain.auth.spi.JwtPort
import esperer.constant.global.security.SecurityProperties
import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
class GenerateJwtAdapter(
    private val securityProperties: SecurityProperties,
    private val commandRefreshTokenPort: CommandRefreshTokenPort
) : JwtPort {

    override fun receiveToken(userId: UUID, authority: Authority): TokenResponse =
        TokenResponse(
            accessToken = generateAccessToken(userId, authority),
            accessTokenExpiredAt = LocalDateTime.now().withNano(0).plusSeconds(securityProperties.accessExp.toLong()),
            refreshToken = generateRefreshToken(userId, authority),
            refreshTokenExpiredAt = LocalDateTime.now().withNano(0).plusSeconds(securityProperties.refreshExp.toLong()),
        )

    private fun generateAccessToken(userId: UUID, authority: Authority) =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, securityProperties.secretKey)
            .setHeaderParam(Header.JWT_TYPE, JwtProperties.ACCESS)
            .setId(userId.toString())
            .claim(JwtProperties.AUTHORITY, authority.name)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + securityProperties.accessExp * 1000))
            .compact()

    private fun generateRefreshToken(userId: UUID, authority: Authority) : String {
        val token = Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, securityProperties.secretKey)
            .setHeaderParam(Header.JWT_TYPE, JwtProperties.REFRESH)
            .setId(userId.toString())
            .claim(JwtProperties.AUTHORITY, authority.name)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + securityProperties.refreshExp * 1000))
            .compact()

        val refreshToken = RefreshToken(
            token = token,
            userId = userId,
            authority = authority,
            expiredAt = securityProperties.refreshExp
        )
        commandRefreshTokenPort.save(refreshToken)

        return token
    }
}