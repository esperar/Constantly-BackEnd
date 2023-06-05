package esperer.constant.domain.auth.model

import esperer.constant.common.annotation.Aggregate
import java.util.UUID

@Aggregate
data class RefreshToken(
    val token: String,
    val userId: UUID,
    val authority: Authority,
    val expiredAt: Int
)
