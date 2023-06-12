package esperer.constant.domain.user.mapper

import esperer.constant.domain.sprint.dto.request.CreateSprintRequest
import esperer.constant.domain.sprint.mapper.SprintMapper
import esperer.constant.domain.sprint.persistence.repository.SprintRepository
import esperer.constant.domain.sprint.spi.QuerySprintPort
import esperer.constant.domain.user.model.User
import esperer.constant.domain.user.persistence.entity.UserJpaEntity
import esperer.constant.domain.user.spi.QueryUserPort
import esperer.constant.global.mapper.GenericMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class UserMapper(
    private val sprintRepository: SprintRepository
) : GenericMapper<User, UserJpaEntity> {

    override fun toDomain(entity: UserJpaEntity?): User? =
        entity?.let {
            User(
                id = it.id,
                email = it.email,
                password = it.password,
                name = it.name,
                authority = it.authority,
                profileFileName = it.profileFileName,
                sprintId = it.sprint?.id
            )
        }


    override fun toEntity(domain: User): UserJpaEntity {
        val sprint = domain.sprintId?.let { sprintRepository.findByIdOrNull(it) }
        return domain.let {
            UserJpaEntity(
                id = it.id,
                email = it.email,
                password = it.password,
                name = it.name,
                authority = it.authority,
                profileFileName = it.profileFileName,
                sprint = sprint
            )
        }
    }
}