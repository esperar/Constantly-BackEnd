package esperer.constant.domain.chat.persistence.entity

import esperer.constant.domain.chat.model.Type
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.ManyToOne
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import java.util.UUID

@RedisHash("chat")
class ChatRedisEntity(

    @Id
    val id: UUID,

    @Enumerated(EnumType.STRING)
    val type: Type,

    val message: String,

    val sender: String,

    @ManyToOne
    val chatRoom: ChatRoomRedisEntity
)