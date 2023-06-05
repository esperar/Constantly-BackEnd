package esperer.constant.global.security.token

import esperer.constant.domain.auth.model.Authority
import esperer.constant.global.exception.InternalServerException
import esperer.constant.global.security.SecurityProperties
import esperer.constant.global.security.exception.ExpiredTokenException
import esperer.constant.global.security.exception.InvalidRoleException
import esperer.constant.global.security.exception.InvalidTokenException
import esperer.constant.global.security.exception.UnexpectedTokenException
import esperer.constant.global.security.principle.AuthDetailsService
import io.jsonwebtoken.*
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.lang.Exception

@Component
class JwtParser(
    private val securityProperties: SecurityProperties,
    private val authDetailsService: AuthDetailsService
) {

    fun getAuthentication(token: String): Authentication{
        val claims = getClaims(token)

        if(claims.header[Header.JWT_TYPE] != JwtProperties.ACCESS){
            throw InvalidTokenException
        }

        val userDetails = getDetails(claims.body)

        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    private fun getClaims(token: String): Jws<Claims>{
        return try{
            Jwts.parserBuilder()
                .setSigningKey(securityProperties.secretKey)
                .build()
                .parseClaimsJws(token)
        } catch(e: Exception){
            when(e){
                is InvalidClaimException -> throw InvalidTokenException
                is ExpiredJwtException -> throw  ExpiredTokenException
                is JwtException -> throw UnexpectedTokenException
                else -> throw InternalServerException
            }
        }
    }

    private fun getDetails(body: Claims): UserDetails =
        authDetailsService.loadUserByUsername(body.id)

}