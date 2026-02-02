package com.github.jmlb23.shop.auth

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.http.MediaType
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/user")
class AuthController {

    @Secured(SecurityRule.IS_ANONYMOUS)
    @Post("/login")
    @Produces(MediaType.APPLICATION_JSON)
    suspend fun login(): HttpResponse<String> {
        return HttpResponse.ok("Example response")
    }
}
