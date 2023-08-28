package esperer.constant.domain.chat.spi

import esperer.constant.domain.chat.model.Chat

interface CommandChatPort {
    fun save(chat: Chat): Chat
}