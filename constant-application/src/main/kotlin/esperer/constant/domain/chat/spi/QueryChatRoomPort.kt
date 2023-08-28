package esperer.constant.domain.chat.spi

import esperer.constant.domain.chat.model.ChatRoom
import java.util.*

interface QueryChatRoomPort {
    fun findById(id: UUID): ChatRoom?
    fun findAll(): List<ChatRoom>
}