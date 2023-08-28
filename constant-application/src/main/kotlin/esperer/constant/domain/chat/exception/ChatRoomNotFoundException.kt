package esperer.constant.domain.chat.exception

import esperer.constant.common.error.ConstantException
import esperer.constant.domain.chat.exception.error.ChatRoomErrorCode

object ChatRoomNotFoundException : ConstantException(ChatRoomErrorCode.CHAT_ROOM_NOT_FOUND)