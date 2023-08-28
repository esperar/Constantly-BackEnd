package esperer.constant.domain.chat.persistence.repository

import esperer.constant.domain.chat.persistence.entity.ChatRoomRedisEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface ChatRoomRepository : CrudRepository<ChatRoomRedisEntity, UUID> {

}