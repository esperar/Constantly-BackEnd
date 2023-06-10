package esperer.constant.domain.sprint.mapper

import esperer.constant.domain.sprint.model.Sprint
import esperer.constant.domain.sprint.persistence.entity.SprintJpaEntity
import esperer.constant.global.mapper.GenericMapper
import org.springframework.stereotype.Component

@Component
class SprintMapper : GenericMapper<Sprint, SprintJpaEntity>{

    override fun toDomain(entity: SprintJpaEntity?): Sprint? {
        return entity?.let {
            Sprint(
                id = it.id,
                title = it.title,
                target = it.target,
                sprintStatus = it.sprintStatus,
                startDate = it.startDate,
                endDate = it.endDate
            )
        }
    }

    override fun toEntity(domain: Sprint): SprintJpaEntity {
        return domain.let {
            SprintJpaEntity(
                id = it.id,
                title = it.title,
                target = it.target,
                sprintStatus = it.sprintStatus,
                startDate = it.startDate,
                endDate = it.endDate
            )
        }
    }
}