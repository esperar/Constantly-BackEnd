package esperer.constant.domain.chat.mapper

import esperer.constant.domain.chat.model.Chat
import esperer.constant.domain.chat.persistence.entity.ChatRedisEntity
import esperer.constant.global.mapper.GenericMapper
import org.springframework.stereotype.Component

@Component
class ChatMapper(
    private val chatRoomMapper: ChatRoomMapper
) : GenericMapper<Chat, ChatRedisEntity> {

    override fun toDomain(entity: ChatRedisEntity?): Chat? =
        entity?.let {
            Chat(
                id = it.id,
                type = it.type,
                message = it.message,
                sender = it.sender,
                chatRoom = chatRoomMapper.toDomain(it.chatRoom)!!
            )
        }

    override fun toEntity(domain: Chat): ChatRedisEntity =
        ChatRedisEntity(
            id = domain.id,
            type = domain.type,
            message = domain.message,
            sender = domain.sender,
            chatRoom = chatRoomMapper.toEntity(domain.chatRoom)
        )
}