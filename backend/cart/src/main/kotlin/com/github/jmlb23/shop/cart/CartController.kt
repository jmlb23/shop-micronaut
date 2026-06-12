package com.github.jmlb23.shop.cart

import com.github.jmlb23.shop.Service
import com.github.jmlb23.shop.cart.api.AddProductRequest
import com.github.jmlb23.shop.cart.api.AddProductResponse
import com.github.jmlb23.shop.cart.api.CreateCartResponse
import com.github.jmlb23.shop.cart.api.DeleteCartResponse
import com.github.jmlb23.shop.cart.api.Payload
import com.github.jmlb23.shop.cart.domain.CartError
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.inject.Inject
import java.util.UUID

@Secured(SecurityRule.IS_AUTHENTICATED)
@SecurityRequirement(name = "BearerAuth")
@Controller
@Tag(name = "Cart", description = "Cart related operations")
class CartController(
    @Inject val addProductToCartService: Service<Payload, CartError, AddProductResponse>,
    @Inject val createCartService: Service<UUID, CartError, CreateCartResponse>,
    @Inject val deleteCartService: Service<UUID, CartError, DeleteCartResponse>
) {

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/cart/{id}")
    fun getCart(id: UUID): HttpResponse<Any> {
        TODO()
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Delete("/cart/{id}")
    suspend fun deleteCart(id: UUID): HttpResponse<DeleteCartResponse> {
        return deleteCartService
            .execute(id)
            .fold({ HttpResponse.status(500, it.toString()) }, { HttpResponse.ok(it) })
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Post("/cart/{id}")
    suspend fun createCart(id: UUID): HttpResponse<CreateCartResponse> {
        return createCartService
            .execute(id)
            .fold({ HttpResponse.status(500, it.toString()) }, { HttpResponse.ok(it) })
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Post("/cart/{id}/items")
    suspend fun addProductCart(
        id: UUID,
        request: AddProductRequest
    ): HttpResponse<AddProductResponse> {
        return addProductToCartService
            .execute(Payload(id, request))
            .fold({ HttpResponse.status(500, it.toString()) }, { HttpResponse.ok(it) })
    }
}
