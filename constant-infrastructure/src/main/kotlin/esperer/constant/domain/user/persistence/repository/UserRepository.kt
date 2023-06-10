package esperer.constant.domain.user.persistence.repository

import esperer.constant.domain.user.persistence.entity.UserJpaEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface UserRepository : CrudRepository<UserJpaEntity, UUID> {

    fun findByEmail(email: String): UserJpaEntity?
}