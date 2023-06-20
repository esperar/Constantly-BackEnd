package esperer.constant.domain.auth.usecase

import esperer.constant.common.service.SecurityService
import esperer.constant.domain.auth.dto.request.SignUpRequest
import esperer.constant.domain.auth.dto.response.TokenResponse
import esperer.constant.domain.auth.model.Authority
import esperer.constant.domain.auth.spi.JwtPort
import esperer.constant.domain.sprint.model.Sprint
import esperer.constant.domain.sprint.model.SprintStatus
import esperer.constant.domain.user.model.User
import esperer.constant.domain.user.service.UserService
import esperer.constant.global.annotation.ConstantTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.MockitoAnnotations
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.given
import org.mockito.kotlin.mock
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.mock.mockito.SpyBean
import org.springframework.test.context.ContextConfiguration
import java.time.LocalDateTime
import java.util.*


@ConstantTest
@ContextConfiguration(classes = [SignUpUseCase::class])
class SignUpUseCaseTest {

    @MockBean
    private lateinit var jwtPort: JwtPort

    @MockBean
    private lateinit var securityService: SecurityService

    @MockBean
    private lateinit var userService: UserService

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
            title = "sprint_title",
            target = "sprint_target",
            startDate = LocalDateTime.now(),
            endDate = LocalDateTime.now(),
            sprintStatus = SprintStatus.BEFORE_START
        )
    }

    @BeforeEach
    fun setUp(){
        MockitoAnnotations.openMocks(this)
        jwtPort = mock()
        userService = mock()
        securityService = mock()

        signUpUseCase = SignUpUseCase(
            userService = userService,
            securityService = securityService,
            jwtPort = jwtPort
        )
    }

    @Test
    fun `회원가입 성공`(){

        given(userService.existsByEmail(requestStub.email)).willReturn(false)

        given(securityService.encodePassword(requestStub.password)).willReturn(saveUserStub.password)

        given(userService.save(any())).willReturn(saveUserStub)

        given(jwtPort.receiveToken(saveUserStub.id, saveUserStub.authority)).willReturn(responseStub)

        // when
        val result = signUpUseCase.execute(requestStub)

        // then
        assertThat(result).isEqualTo(responseStub)
    }
}