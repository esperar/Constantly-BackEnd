package esperer.constant.global.exception

import esperer.constant.common.error.ConstantException
import esperer.constant.global.error.GlobalErrorCode

object InternalServerException : ConstantException(
    GlobalErrorCode.INTERNAL_SERVER_ERROR
)