package esperer.constant.domain.user.model

import esperer.constant.common.annotation.Aggregate
import esperer.constant.domain.auth.model.Authority
import java.util.*

@Aggregate
data class User(
    val id: UUID,
    val email: String,
    val password: String,
    val name: String,
    val profileFileName: String,
    val authority: Authority
)
