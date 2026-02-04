package com.github.jmlb23.shop.product

import com.github.jmlb23.shop.Service
import com.github.jmlb23.shop.product.api.*
import com.github.jmlb23.shop.product.domain.Product
import com.github.jmlb23.shop.product.domain.ProductError
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.http.annotation.Status
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import jakarta.inject.Inject
import java.util.Date
import java.util.UUID

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/product")
class ProductController(@Inject val createProductService: Service<UUID, ProductError, CreatedProductResponse>) {

    @Secured(SecurityRule.IS_ANONYMOUS)
    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    fun index(): HttpResponse<Map<String, String>> {
        return HttpResponse.ok(mapOf("hola" to "mundo"))
    }

    @Get("/{id}")
    suspend fun getProductBy(id: UUID): HttpResponse<CreatedProductResponse> {
        return createProductService
                .execute(id)
                .fold({
                    HttpResponse.badRequest()
                }, {
                    HttpResponse.ok(it)
                }) 
    }

    @Post("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Status(HttpStatus.CREATED)
    fun addProducts(@Body prod: CreateProduct): HttpResponse<CreatedProductResponse> {
        return HttpResponse.ok(
                        CreatedProductResponse(
                                UUID.randomUUID(),
                                prod.name,
                                prod.description,
                                prod.price,
                                Date()
                        )
                )
                .header("location", "/product/${UUID.randomUUID().toString()}")
    }
}
