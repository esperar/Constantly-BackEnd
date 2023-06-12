package esperer.constant.domain.sprint.presentation

import esperer.constant.domain.sprint.presentation.dto.request.CreateSprintWebRequest
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Validated
@RestController
@RequestMapping("/sprint")
class SprintWebAdapter {

    @PostMapping
    fun createSprint(@RequestBody @Valid request: CreateSprintWebRequest){

    }
}