package esperer.constant.domain.chat.usecase

import esperer.constant.common.annotation.ReadOnlyUseCase
import esperer.constant.domain.chat.dto.ChatRoomDto
import esperer.constant.domain.chat.dto.toDto
import esperer.constant.domain.chat.spi.QueryChatRoomPort

@ReadOnlyUseCase
class QueryAllChatRoomUseCase(
    private val queryChatRoomPort: QueryChatRoomPort
) {

    fun execute() : List<ChatRoomDto> =
        queryChatRoomPort.findAll().map { it.toDto() }

}