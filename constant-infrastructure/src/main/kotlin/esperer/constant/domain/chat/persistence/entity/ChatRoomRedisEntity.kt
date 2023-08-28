package esperer.constant.domain.chat.persistence.entity

import org.springframework.data.redis.core.RedisHash
import java.util.UUID

@RedisHash("chat_room")
class ChatRoomRedisEntity(
    val id: UUID,
    val name: String
)