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
class ProductController(
    @Inject val getProductByIdService: Service<UUID, ProductError, GetProductByIdResponse>,
    @Inject val getAllProductsService: Service<Unit, ProductError, List<ProductDTO>>,
) {

    @Secured(SecurityRule.IS_ANONYMOUS)
    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    suspend fun index(): HttpResponse<List<ProductDTO>> {
        return getAllProductsService
                .execute(Unit)
                .fold({
                    HttpResponse.serverError()
                },{
                    HttpResponse.ok(it)
                })
    }

    @Get("/{id}")
    suspend fun getProductBy(id: UUID): HttpResponse<GetProductByIdResponse> {
        return getProductByIdService
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
    fun addProducts(@Body prod: Any): HttpResponse<Any> {
        TODO()
    }
}
