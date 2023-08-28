package esperer.constant.domain.chat.usecase

import esperer.constant.common.annotation.ReadOnlyUseCase
import esperer.constant.domain.chat.dto.ChatRoomDto
import esperer.constant.domain.chat.dto.toDto
import esperer.constant.domain.chat.exception.ChatRoomNotFoundException
import esperer.constant.domain.chat.spi.QueryChatRoomPort
import java.util.UUID

@ReadOnlyUseCase
class QueryChatRoomByIdUseCase(
    private val queryChatRoomPort: QueryChatRoomPort
) {

    fun execute(id : UUID): ChatRoomDto {
        val chatRoom = queryChatRoomPort.findById(id) ?: throw ChatRoomNotFoundException

        return chatRoom.toDto()
    }
}