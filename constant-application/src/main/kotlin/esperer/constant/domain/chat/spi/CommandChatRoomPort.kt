package esperer.constant.domain.chat.spi

import esperer.constant.domain.chat.model.ChatRoom

interface CommandChatRoomPort {
    fun save(chatRoom: ChatRoom): ChatRoom
}