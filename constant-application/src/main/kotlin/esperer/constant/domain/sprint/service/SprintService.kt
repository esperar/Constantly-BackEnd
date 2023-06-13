package esperer.constant.domain.sprint.service

import esperer.constant.common.annotation.Service

@Service
class SprintService(
    commandSprintService: CommandSprintService,
    querySprintService: QuerySprintService
) : CommandSprintService by commandSprintService, QuerySprintService by querySprintService