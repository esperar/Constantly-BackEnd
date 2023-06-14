package esperer.constant.domain.user.persistence

import esperer.constant.domain.sprint.mapper.SprintMapper
import esperer.constant.domain.sprint.model.Sprint
import esperer.constant.domain.user.mapper.UserMapper
import esperer.constant.domain.user.model.User
import esperer.constant.domain.user.persistence.repository.UserRepository
import esperer.constant.domain.user.spi.UserPort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserPersistenceAdapter(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper,
    private val sprintMapper: SprintMapper
) : UserPort {

    override fun queryUserById(id: UUID): User? =
        userMapper.toDomain(userRepository.findByIdOrNull(id))

    override fun queryUserByEmail(email: String): User? =
        userMapper.toDomain(userRepository.findByEmail(email))

    override fun queryAllUserBySprint(sprint: Sprint): List<User> =
        userRepository.findAllBySprint(sprintMapper.toEntity(sprint)).map { userMapper.toDomain(it)!! }

    override fun save(user: User): User =
        userMapper.toDomain(userRepository.save(userMapper.toEntity(user)))!!
}