package esperer.constant.domain.chat.mapper

import esperer.constant.domain.chat.model.ChatRoom
import esperer.constant.domain.chat.persistence.entity.ChatRoomRedisEntity
import esperer.constant.global.mapper.GenericMapper
import org.springframework.stereotype.Component

@Component
class ChatRoomMapper : GenericMapper<ChatRoom, ChatRoomRedisEntity> {

    override fun toDomain(entity: ChatRoomRedisEntity?): ChatRoom? =
        entity?.let {
            ChatRoom(
                id = it.id,
                name = it.name
            )
        }

    override fun toEntity(domain: ChatRoom): ChatRoomRedisEntity =
        ChatRoomRedisEntity(
            id = domain.id,
            name = domain.name
        )
}