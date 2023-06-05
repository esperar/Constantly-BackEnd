package esperer.constant.domain.auth.mapper

import esperer.constant.domain.auth.model.RefreshToken
import esperer.constant.domain.auth.persistence.entity.RefreshTokenEntity
import esperer.constant.global.mapper.GenericMapper
import org.springframework.stereotype.Component

@Component
class RefreshTokenMapper : GenericMapper<RefreshToken, RefreshTokenEntity>{

    override fun toDomain(entity: RefreshTokenEntity?): RefreshToken? =
        entity?.let {
            RefreshToken(
                token = it.token,
                userId = it.userId,
                authority = it.authority,
                expiredAt = it.expiredAt
            )
        }

    override fun toEntity(domain: RefreshToken): RefreshTokenEntity =
        domain.let {
            RefreshTokenEntity(
                token = it.token,
                userId = it.userId,
                authority = it.authority,
                expiredAt = it.expiredAt
            )
        }
}