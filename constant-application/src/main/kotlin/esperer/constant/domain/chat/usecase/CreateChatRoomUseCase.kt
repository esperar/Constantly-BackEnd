package esperer.constant.domain.chat.usecase

import esperer.constant.common.annotation.UseCase
import esperer.constant.domain.chat.dto.ChatRoomDto
import esperer.constant.domain.chat.dto.toDto
import esperer.constant.domain.chat.model.ChatRoom
import esperer.constant.domain.chat.spi.CommandChatRoomPort
import java.util.*

@UseCase
class CreateChatRoomUseCase(
    private val commandChatRoomPort: CommandChatRoomPort
) {

    fun execute(name: String) : ChatRoomDto {

        val chatRoom = ChatRoom(
            id = UUID.randomUUID(),
            name = name
        )

        return commandChatRoomPort.save(chatRoom).toDto()
    }
}