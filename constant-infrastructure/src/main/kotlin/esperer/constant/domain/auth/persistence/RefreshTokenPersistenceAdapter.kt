package esperer.constant.domain.auth.persistence

import esperer.constant.domain.auth.mapper.RefreshTokenMapper
import esperer.constant.domain.auth.model.RefreshToken
import esperer.constant.domain.auth.persistence.repository.RefreshTokenRepository
import esperer.constant.domain.auth.spi.RefreshTokenPort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class RefreshTokenPersistenceAdapter(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val refreshTokenMapper: RefreshTokenMapper
) : RefreshTokenPort {

    override fun queryRefreshTokenByToken(token: String): RefreshToken? =
        refreshTokenMapper.toDomain(refreshTokenRepository.findByIdOrNull(token))

    override fun save(refreshToken: RefreshToken): RefreshToken =
        refreshTokenMapper.toDomain(refreshTokenRepository.save(refreshTokenMapper.toEntity(refreshToken)))!!
}