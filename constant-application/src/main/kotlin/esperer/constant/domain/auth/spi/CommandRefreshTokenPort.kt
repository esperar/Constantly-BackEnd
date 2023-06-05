package esperer.constant.domain.auth.spi

import esperer.constant.domain.auth.model.RefreshToken

interface CommandRefreshTokenPort {
    fun save(refreshToken: RefreshToken): RefreshToken
}