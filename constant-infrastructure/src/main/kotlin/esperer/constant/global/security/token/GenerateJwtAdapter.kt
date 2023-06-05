package esperer.constant.global.security.token

import esperer.constant.domain.auth.dto.response.TokenResponse
import esperer.constant.domain.auth.model.Authority
import esperer.constant.domain.auth.spi.JwtPort
import org.springframework.stereotype.Component
import java.util.*

@Component
class GenerateJwtAdapter : JwtPort {
    
    override fun receiveToken(userId: UUID, authority: Authority): TokenResponse {
        TODO("Not yet implemented")
    }
}