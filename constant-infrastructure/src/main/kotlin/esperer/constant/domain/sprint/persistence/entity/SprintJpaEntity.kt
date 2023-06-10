package esperer.constant.domain.sprint.persistence.entity

import esperer.constant.domain.sprint.model.SprintStatus
import esperer.constant.global.entity.BaseUUIDEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import java.time.LocalDateTime
import java.util.UUID

@Entity
class SprintJpaEntity(
    override val id: UUID,

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    val title: String,

    @Column(columnDefinition = "VARCHAR(1000)",nullable = false)
    val target: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val sprintStatus: SprintStatus,

    @Column(columnDefinition = "DATETIME", nullable = false)
    val startDate: LocalDateTime,

    @Column(columnDefinition = "DATETIME", nullable = false)
    val endDate: LocalDateTime

) : BaseUUIDEntity(id)