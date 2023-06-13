package esperer.constant.domain.sprint.exception

import esperer.constant.common.error.ConstantException
import esperer.constant.domain.sprint.exception.error.SprintErrorCode

object SprintNotFoundException : ConstantException(SprintErrorCode.SPRINT_NOT_FOUND)