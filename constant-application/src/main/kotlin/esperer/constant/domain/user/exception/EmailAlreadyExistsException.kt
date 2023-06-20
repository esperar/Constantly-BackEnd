package esperer.constant.domain.user.exception

import esperer.constant.common.error.ConstantException
import esperer.constant.domain.user.exception.error.UserErrorCode

object EmailAlreadyExistsException : ConstantException(UserErrorCode.EMAIL_ALREADY_EXISTS)