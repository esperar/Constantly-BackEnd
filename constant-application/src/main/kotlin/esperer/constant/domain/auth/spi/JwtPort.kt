package esperer.constant.domain.auth.spi

import esperer.constant.domain.auth.dto.response.TokenResponse
import esperer.constant.domain.auth.model.Authority
import java.util.*

interface JwtPort {
    fun receiveToken(userId: UUID, authority: Authority): TokenResponse
}