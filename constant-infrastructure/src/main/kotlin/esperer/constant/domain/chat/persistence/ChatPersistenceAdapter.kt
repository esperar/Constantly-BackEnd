package esperer.constant.domain.chat.persistence

import esperer.constant.domain.chat.mapper.ChatMapper
import esperer.constant.domain.chat.model.Chat
import esperer.constant.domain.chat.persistence.repository.ChatRepository
import esperer.constant.domain.chat.spi.ChatPort
import org.springframework.stereotype.Component

@Component
class ChatPersistenceAdapter(
    private val chatRepository: ChatRepository,
    private val chatMapper: ChatMapper
) : ChatPort {

    override fun save(chat: Chat): Chat =
        chatMapper.toDomain(chatRepository.save(chatMapper.toEntity(chat)))!!
}