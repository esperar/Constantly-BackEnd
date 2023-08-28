package esperer.constant.domain.chat.presentation

import esperer.constant.domain.chat.dto.ChatDto
import esperer.constant.domain.chat.dto.ChatRoomDto
import esperer.constant.domain.chat.presentation.data.request.ChatRequest
import esperer.constant.domain.chat.usecase.CreateChatRoomUseCase
import esperer.constant.domain.chat.usecase.QueryAllChatRoomUseCase
import esperer.constant.domain.chat.usecase.QueryChatRoomByIdUseCase
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class ChatRoomWebAdapter(
    private val createChatRoomUseCase: CreateChatRoomUseCase,
    private val queryChatRoomByIdUseCase: QueryChatRoomByIdUseCase,
    private val queryAllChatRoomUseCase: QueryAllChatRoomUseCase
) {

    @MessageMapping("/pub/chat/room/{room_id}")
    @SendTo("/sub/chat/room/{room_id}")
    fun message(@DestinationVariable("room_id") roomId: UUID, request: ChatRequest) : ChatDto {

        // 채팅 기록 저장 로직

        return ChatDto(
            type = request.type,
            message = request.message,
            sender = request.sender
        )
    }
}