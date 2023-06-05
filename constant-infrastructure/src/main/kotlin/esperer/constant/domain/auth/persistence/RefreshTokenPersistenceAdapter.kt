package esperer.constant.domain.auth.persistence

import esperer.constant.domain.auth.model.RefreshToken
import esperer.constant.domain.auth.persistence.repository.RefreshTokenRepository
import esperer.constant.domain.auth.spi.RefreshTokenPort
import org.springframework.stereotype.Component

@Component
class RefreshTokenPersistenceAdapter(
    private val refreshTokenRepository: RefreshTokenRepository
) : RefreshTokenPort {

    override fun queryRefreshTokenByToken(token: String): RefreshToken? {
        TODO("Not yet implemented")
    }

    override fun save(refreshToken: RefreshToken): RefreshToken {
        TODO("Not yet implemented")
    }
}