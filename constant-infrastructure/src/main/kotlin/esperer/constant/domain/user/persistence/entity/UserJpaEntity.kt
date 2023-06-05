package esperer.constant.domain.user.persistence.entity

import esperer.constant.domain.auth.model.Authority
import esperer.constant.global.entity.BaseUUIDEntity
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "tbl_user")
class UserJpaEntity(

    override val id: UUID,

    @Column(columnDefinition = "VARCHAR(30)", nullable = false, unique = true)
    val email: String,

    @Column(columnDefinition = "CHAR(60)", nullable = false)
    val password: String,

    @Column(columnDefinition = "VARCHAR(15)", nullable = false)
    val name: String,

    @Column(columnDefinition = "VARCHAR(500)", nullable = false)
    val profileFileName: String,

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(7)", nullable = false)
    val authority: Authority


) : BaseUUIDEntity(id)