package esperer.constant.global.security.exception

import esperer.constant.common.error.ConstantException
import esperer.constant.global.security.error.SecurityErrorCode

object ExpiredTokenException : ConstantException(SecurityErrorCode.EXPIRED_TOKEN)