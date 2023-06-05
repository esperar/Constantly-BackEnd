package esperer.constant.domain.user.persistence

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
    private val userMapper: UserMapper
) : UserPort {

    override fun queryUserById(id: UUID): User? =
        userMapper.toDomain(userRepository.findByIdOrNull(id))
}