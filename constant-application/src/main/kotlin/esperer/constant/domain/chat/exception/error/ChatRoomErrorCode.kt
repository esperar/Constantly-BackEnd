package esperer.constant.domain.chat.exception.error

import esperer.constant.common.error.ErrorProperty

enum class ChatRoomErrorCode(
    private val status: Int,
    private val message: String
) : ErrorProperty {

    CHAT_ROOM_NOT_FOUND(404, "chat room is not found")
    ;

    override fun status(): Int = status
    override fun message(): String = message

}