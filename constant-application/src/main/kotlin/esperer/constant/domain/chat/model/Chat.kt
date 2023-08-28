package esperer.constant.domain.chat.model

import java.util.UUID

data class Chat(
    val id: UUID,
    val type: Type,
    val message: String,
    val sender: String,
    val chatRoom: ChatRoom
)
