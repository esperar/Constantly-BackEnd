package esperer.constant.global.security.exception

import esperer.constant.common.error.ConstantException
import esperer.constant.global.security.error.SecurityErrorCode

object InvalidTokenException : ConstantException(SecurityErrorCode.INVALID_TOKEN)