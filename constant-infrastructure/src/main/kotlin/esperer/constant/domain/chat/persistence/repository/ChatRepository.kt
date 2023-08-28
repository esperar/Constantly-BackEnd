package esperer.constant.domain.chat.persistence.repository

import esperer.constant.domain.chat.persistence.entity.ChatRedisEntity
import org.springframework.data.repository.CrudRepository

interface ChatRepository : CrudRepository<ChatRedisEntity, Long> {
}