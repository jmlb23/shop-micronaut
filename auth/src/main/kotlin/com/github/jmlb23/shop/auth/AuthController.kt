package com.github.jmlb23.shop.auth

import com.github.jmlb23.shop.Service
import com.github.jmlb23.shop.auth.api.Request
import com.github.jmlb23.shop.auth.api.Response
import com.github.jmlb23.shop.auth.domain.AuthDomainError
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import jakarta.inject.Inject

@Controller("/user")
class AuthController(@Inject val userService: Service<Request, AuthDomainError, String>) {

    @Secured(SecurityRule.IS_ANONYMOUS)
    @Post("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    suspend fun login(@Body request: Request): HttpResponse<Response> {
        return userService
                .execute(request)
                .fold({ 
                    when (it) {
                        AuthDomainError.CredentialsError -> HttpResponse.unauthorized()
                        else -> HttpResponse.notFound()
                    }
                }, { HttpResponse.ok(Response(it)) })
    }
}
