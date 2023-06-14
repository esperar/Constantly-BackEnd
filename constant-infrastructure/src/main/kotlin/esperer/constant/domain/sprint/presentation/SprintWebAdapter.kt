package esperer.constant.domain.sprint.presentation

import esperer.constant.domain.sprint.dto.request.CreateSprintRequest
import esperer.constant.domain.sprint.dto.response.SprintsResponse
import esperer.constant.domain.sprint.presentation.dto.request.CreateSprintWebRequest
import esperer.constant.domain.sprint.usecase.CreateSprintUseCase
import esperer.constant.domain.sprint.usecase.QueryAllSprintUseCase
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Validated
@RestController
@RequestMapping("/sprint")
class SprintWebAdapter(
    private val createSprintUseCase: CreateSprintUseCase,
    private val queryAllSprintUseCase: QueryAllSprintUseCase
) {

    @PostMapping
    fun createSprint(@RequestBody @Valid request: CreateSprintWebRequest){
        createSprintUseCase.execute(
            CreateSprintRequest(
                title = request.title,
                target = request.target,
                startDate = request.startDate,
                endDateTime = request.endDate
            )
        )
    }

    @GetMapping
    fun queryAllSprint(): SprintsResponse{
        return queryAllSprintUseCase.execute()
    }
}