package esperer.constant.global.filter

import com.fasterxml.jackson.databind.ObjectMapper
import esperer.constant.common.error.ConstantException
import esperer.constant.common.error.ErrorProperty
import esperer.constant.global.error.ErrorResponse
import esperer.constant.global.exception.InternalServerException
import io.sentry.Sentry
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.lang.Exception
import java.nio.charset.StandardCharsets

class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        try{
            filterChain.doFilter(request, response)
        } catch(e : Exception){
            when(e.cause){
                is ConstantException -> {
                    errorToJson((e.cause as ConstantException).errorProperty, response)
                }

                is Exception -> {
                    errorToJson(InternalServerException.errorProperty, response)
                }
            }
            Sentry.captureException(e)
        }
    }

    private fun errorToJson(errorProperty: ErrorProperty, response: HttpServletResponse) {
        response.status = errorProperty.status()
        response.characterEncoding = StandardCharsets.UTF_8.name()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(objectMapper.writeValueAsString(ErrorResponse.of(errorProperty)))
    }
}