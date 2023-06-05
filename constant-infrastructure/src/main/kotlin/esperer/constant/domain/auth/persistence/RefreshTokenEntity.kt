package esperer.constant.domain.auth.persistence

import esperer.constant.domain.auth.model.Authority
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import java.util.*

@RedisHash("tbl_refresh_token")
data class RefreshTokenEntity(

    @Id
    val token: String,

    val userId: UUID,

    val authority: Authority,

    @TimeToLive
    val expirationTime: Int

)