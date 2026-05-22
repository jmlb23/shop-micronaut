package com.github.jmlb23.shop.cart

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import java.util.UUID

@Secured(SecurityRule.IS_AUTHENTICATED)
@SecurityRequirement(name = "BearerAuth")
@Controller
@Tag(name = "Cart", description = "Cart related operations")
class CartController {

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Get("/cart/{id}")
    fun getCart(id: UUID): HttpResponse<Any> {
        TODO()
    }
    
    @Delete("/cart/{id}")
    fun deleteCart(id: UUID): HttpResponse<Any> {
        TODO()
    }

} 
