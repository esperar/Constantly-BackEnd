package esperer.constant.domain.user.mapper

import esperer.constant.domain.user.model.User
import esperer.constant.domain.user.persistence.entity.UserJpaEntity
import esperer.constant.global.mapper.GenericMapper
import org.springframework.stereotype.Component

@Component
class UserMapper : GenericMapper<User, UserJpaEntity> {

    override fun toDomain(entity: UserJpaEntity?): User? =
        entity?.let {
            User(
                id = it.id,
                email = it.email,
                password = it.password,
                name = it.name,
                authority = it.authority,
                profileFileName = it.profileFileName
            )
        }


    override fun toEntity(domain: User): UserJpaEntity {
        return domain.let {
            UserJpaEntity(
                id = it.id,
                email = it.email,
                password = it.password,
                name = it.name,
                authority = it.authority,
                profileFileName = it.profileFileName
            )
        }
    }
}