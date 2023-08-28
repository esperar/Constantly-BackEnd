package esperer.constant.domain.chat.model

data class Chat(
    val id: Long,
    val type: Type,
    val message: String,
    val sender: String,
    val chatRoom: ChatRoom
)
