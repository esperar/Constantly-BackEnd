package esperer.constant.domain.auth.usecase

import esperer.constant.common.service.SecurityService
import esperer.constant.domain.auth.dto.request.SignUpRequest
import esperer.constant.domain.auth.dto.response.TokenResponse
import esperer.constant.domain.auth.model.Authority
import esperer.constant.domain.auth.spi.JwtPort
import esperer.constant.domain.sprint.model.Sprint
import esperer.constant.domain.sprint.model.SprintStatus
import esperer.constant.domain.user.model.User
import esperer.constant.domain.user.service.*
import esperer.constant.global.annotation.ConstantTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.given
import org.springframework.boot.test.mock.mockito.MockBean
import java.time.LocalDateTime
import java.util.*

@ConstantTest
class SignUpUseCaseTest {

    @MockBean
    private lateinit var securityService: SecurityService

    @MockBean
    private lateinit var userService: UserService

    @MockBean
    private lateinit var jwtPort: JwtPort

    private lateinit var signUpUseCase: SignUpUseCase


    private val email = "test1@gmail.com"
    private val name = "테스트"
    private val profileFileName = "profileFileName"

    private val saveUserStub: User by lazy {
        User(
            id = UUID.randomUUID(),
            email = email,
            password = "encoded_test_password",
            name = name,
            profileFileName = profileFileName,
            authority = Authority.ROLE_USER,
            sprintId = null
        )
    }

    private val requestStub: SignUpRequest by lazy {
        SignUpRequest(
            email = email,
            password = "test_password",
            name = name,
            profileFileName = profileFileName
        )
    }

    private val responseStub: TokenResponse by lazy {
        TokenResponse(
            accessToken = "access_token",
            accessTokenExpiredAt = LocalDateTime.now(),
            refreshToken = "refreshToken",
            refreshTokenExpiredAt = LocalDateTime.now()
        )
    }

    private val sprintStub: Sprint by lazy {
        Sprint(
            id = UUID.randomUUID(),
            title = "sprint title",
            target = "sprint target",
            startDate = LocalDateTime.now(),
            endDate = LocalDateTime.now(),
            sprintStatus = SprintStatus.BEFORE_START
        )
    }

    @BeforeEach
    fun setUp(){
        MockitoAnnotations.openMocks(this)

        signUpUseCase = SignUpUseCase(
            userService,
            securityService,
            jwtPort
        )
    }

    @Test
    fun `회원가입 성공`(){
        // given
        val userStub = User(
            email = email,
            password = "encoded_test_password",
            name = name,
            profileFileName = profileFileName,
            authority = Authority.ROLE_USER,
            sprintId = sprintStub.id
        )

        given(userService.existsByEmail(requestStub.email)).willReturn(false)

        given(securityService.encodePassword(requestStub.password)).willReturn(userStub.password)

        given(userService.save(userStub)).willReturn(saveUserStub)

        given(jwtPort.receiveToken(saveUserStub.id, saveUserStub.authority)).willReturn(responseStub)

        // when
        val result = signUpUseCase.execute(requestStub)

        // then
        assertThat(result).isEqualTo(responseStub)
    }
}