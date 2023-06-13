package esperer.constant.domain.user.service

import esperer.constant.common.annotation.Service

@Service
class UserService(
    commandUserService: CommandUserService,
    queryUserService: QueryUserService
) : CommandUserService by commandUserService,
    QueryUserService by queryUserService