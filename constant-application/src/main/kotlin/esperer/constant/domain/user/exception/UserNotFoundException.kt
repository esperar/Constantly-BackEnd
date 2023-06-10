package esperer.constant.domain.user.exception

import esperer.constant.common.error.ConstantException
import esperer.constant.domain.user.exception.error.UserErrorCode

object UserNotFoundException : ConstantException(UserErrorCode.USER_NOT_FOUND)