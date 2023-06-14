package esperer.constant.domain.sprint.persistence

import esperer.constant.domain.sprint.mapper.SprintMapper
import esperer.constant.domain.sprint.model.Sprint
import esperer.constant.domain.sprint.persistence.repository.SprintRepository
import esperer.constant.domain.sprint.spi.SprintPort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.*

@Component
class SprintPersistenceAdapter(
    private val sprintMapper: SprintMapper,
    private val sprintRepository: SprintRepository
) : SprintPort {


    override fun querySprintById(id: UUID): Sprint? =
        sprintMapper.toDomain(sprintRepository.findByIdOrNull(id))

    override fun queryAllSprint(): List<Sprint> =
        sprintRepository.findAll().map { sprintMapper.toDomain(it)!! }

    override fun save(sprint: Sprint): Sprint =
        sprintMapper.toDomain(sprintRepository.save(sprintMapper.toEntity(sprint)))!!
}