package esperer.constant.domain.chat.persistence

import esperer.constant.domain.chat.mapper.ChatRoomMapper
import esperer.constant.domain.chat.model.ChatRoom
import esperer.constant.domain.chat.persistence.repository.ChatRoomRepository
import esperer.constant.domain.chat.spi.ChatRoomPort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.*

@Component
class ChatRoomPersistenceAdapter(
    private val chatRoomRepository: ChatRoomRepository,
    private val chatRoomMapper: ChatRoomMapper
) : ChatRoomPort {

    override fun save(chatRoom: ChatRoom): ChatRoom =
        chatRoomMapper.toDomain(chatRoomRepository.save(chatRoomMapper.toEntity(chatRoom)))!!

    override fun findById(id: UUID): ChatRoom? =
        chatRoomRepository.findByIdOrNull(id).let { chatRoomMapper.toDomain(it) }

    override fun findAll(): List<ChatRoom> =
        chatRoomRepository.findAll().map { chatRoomMapper.toDomain(it)!! }
}