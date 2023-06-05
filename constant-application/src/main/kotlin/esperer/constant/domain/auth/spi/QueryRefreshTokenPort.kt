package esperer.constant.domain.auth.spi

import esperer.constant.domain.auth.model.RefreshToken

interface QueryRefreshTokenPort {

    fun queryRefreshTokenByToken(token: String): RefreshToken?
}