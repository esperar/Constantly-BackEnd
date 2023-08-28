package esperer.constant.domain.chat.presentation.data.request

import esperer.constant.domain.chat.model.Type
import org.jetbrains.annotations.NotNull


data class ChatRequest(
    @field:NotNull
    val type: Type,
    @field:NotNull
    val message: String,
    @field:NotNull
    val sender: String
)