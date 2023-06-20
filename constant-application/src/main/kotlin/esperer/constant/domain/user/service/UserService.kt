package esperer.constant.domain.user.service

import esperer.constant.common.annotation.Service

@Service
class UserService(
    commandUserService: CommandUserService,
    queryUserService: QueryUserService,
    checkUserService: CheckUserService
) : CommandUserService by commandUserService,
    QueryUserService by queryUserService,
    CheckUserService by checkUserService