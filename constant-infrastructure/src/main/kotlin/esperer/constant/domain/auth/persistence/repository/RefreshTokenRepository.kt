package esperer.constant.domain.auth.persistence.repository

import esperer.constant.domain.auth.persistence.entity.RefreshTokenEntity
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshTokenEntity, String>