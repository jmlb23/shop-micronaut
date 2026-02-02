package com.github.jmlb23.shop.auth

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.http.MediaType
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule

@Controller("/user")
class AuthController {

    @Secured(SecurityRule.IS_ANONYMOUS)
    @Post("/login")
    @Produces(MediaType.APPLICATION_JSON)
    suspend fun login(): HttpResponse<Map<String, String>> {
        return HttpResponse.ok(mapOf("Example" to "response"))
    }

    @Secured(SecurityRule.IS_AUTHENTICATED)
    @Post("/logout")
    @Produces(MediaType.APPLICATION_JSON)
    suspend fun logout(): HttpResponse<Map<String, String>>{
        return HttpResponse.ok(mapOf("Example" to "response"))
    }
}
