package esperer.constant.domain.sprint.persistence.repository

import esperer.constant.domain.sprint.persistence.entity.SprintJpaEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface SprintRepository : CrudRepository<SprintJpaEntity, UUID> {
}