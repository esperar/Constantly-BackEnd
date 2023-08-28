package esperer.constant.domain.chat.dto

import esperer.constant.domain.chat.model.ChatRoom
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.UUID

data class ChatDto(
    val type: Type,
    val sender: String,
    val message: String
) {

    val createdAt: Long = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli()

    enum class Type {
        ENTER, COMMENT
    }
}

data class ChatRoomDto(
    val id: UUID,
    val name: String
)

internal fun ChatRoom.toDto() = ChatRoomDto(id = id, name = name)