package esperer.constant.domain.chat.presentation

import esperer.constant.domain.chat.dto.ChatDto
import esperer.constant.domain.chat.dto.ChatRoomDto
import esperer.constant.domain.chat.presentation.data.request.ChatRequest
import esperer.constant.domain.chat.usecase.CreateChatRoomUseCase
import esperer.constant.domain.chat.usecase.QueryAllChatRoomUseCase
import esperer.constant.domain.chat.usecase.QueryChatRoomByIdUseCase
import esperer.constant.domain.chat.usecase.SendChatUseCase
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
class ChatRoomWebAdapter(
    private val createChatRoomUseCase: CreateChatRoomUseCase,
    private val queryChatRoomByIdUseCase: QueryChatRoomByIdUseCase,
    private val queryAllChatRoomUseCase: QueryAllChatRoomUseCase,
    private val sendChatUseCase: SendChatUseCase
) {

    @MessageMapping("/pub/chat/room/{room_id}")
    @SendTo("/sub/chat/room/{room_id}")
    fun message(@DestinationVariable("room_id") roomId: UUID, request: ChatRequest) : ChatDto {

        val chatDto = ChatDto(
            type = request.type,
            message = request.message,
            sender = request.sender
        )

        sendChatUseCase.execute(roomId, chatDto)

        return chatDto
    }

    @PostMapping("/api/v1/chat/room")
    fun createRoom(@RequestParam name: String): ChatRoomDto {
        return createChatRoomUseCase.execute(name)
    }

    @GetMapping("/api/v1/chat/room/{room_id}")
    fun queryChatRoomById(@PathVariable("room_id") id: UUID): ChatRoomDto {
        return queryChatRoomByIdUseCase.execute(id)
    }

    @GetMapping("/api/v1/chat/room")
    fun queryAllChatRoom(): List<ChatRoomDto> {
        return queryAllChatRoomUseCase.execute()
    }
}