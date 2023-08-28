package esperer.constant.domain.chat.usecase

import esperer.constant.common.annotation.UseCase
import esperer.constant.domain.chat.dto.ChatDto
import esperer.constant.domain.chat.exception.ChatRoomNotFoundException
import esperer.constant.domain.chat.model.Chat
import esperer.constant.domain.chat.spi.CommandChatPort
import esperer.constant.domain.chat.spi.QueryChatRoomPort
import java.util.UUID

@UseCase
class SendChatUseCase(
    private val commandChatPort: CommandChatPort,
    private val queryChatRoomPort: QueryChatRoomPort
) {

    fun execute(roomId: UUID, dto: ChatDto) {
        val chatRoom = queryChatRoomPort.findById(roomId) ?: throw ChatRoomNotFoundException

        val chat = Chat(
            id = UUID.randomUUID(),
            type = dto.type,
            message = dto.message,
            sender = dto.sender,
            chatRoom = chatRoom
        )

        commandChatPort.save(chat)
    }
}