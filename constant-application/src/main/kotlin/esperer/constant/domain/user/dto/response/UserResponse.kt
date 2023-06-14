package esperer.constant.domain.user.dto.response

import esperer.constant.domain.user.model.User
import java.util.*

data class UserResponse(
    val id: UUID,
    val email: String,
    val name: String
) {
    companion object {
        fun of(user: User): UserResponse{
            return UserResponse(
                id = user.id,
                email = user.email,
                name = user.name
            )
        }
    }
}

data class UsersResponse(
    val users: List<UserResponse>
)

data class UserIdResponse(
    val userId: UUID
)