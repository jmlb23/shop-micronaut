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
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Put
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import jakarta.inject.Inject
import java.util.Date
import java.util.UUID

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/product")
@SecurityRequirement(name = "BearerAuth")
class ProductController(
    @Inject val getProductByIdService: Service<UUID, ProductError, GetProductByIdResponse>,
    @Inject val getAllProductsService: Service<Unit, ProductError, List<ProductDTO>>,
    @Inject val addProduct: Service<CreateProductDTO, ProductError, UUID>,
    @Inject val deleteProduct: Service<UUID, ProductError, UUID>,
    @Inject val updateProductByIdService: Service<UpdateProductByIdSerive.Request, ProductError, UUID>,
) {

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    suspend fun index(): HttpResponse<List<ProductDTO>> {
        return getAllProductsService
                .execute(Unit)
                .fold({
                    HttpResponse.status(500, it.toString())
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
    suspend fun addProducts(@Body prod: CreateProductDTO): HttpResponse<UUID> {
        return addProduct
                .execute(prod)
                .fold({
                    HttpResponse.status(500, it.toString())
                }, {
                    HttpResponse.created(it)
                }) 
    }

    @Delete("/{id}")
    suspend fun deleteProduct(id: UUID): HttpResponse<Nothing> {
        return deleteProduct
            .execute(id)
            .fold({
                HttpResponse.status(500, it.toString())
            }, { 
                HttpResponse.noContent()
            })
    }

    @Put("/{id}")
    suspend fun updateProduct(id: UUID, @Body request: UpdateProductByIdSerive.ProductUpdatePayload): HttpResponse<Nothing> {
        return updateProductByIdService
            .execute(UpdateProductByIdSerive.Request(id, request))
            .fold({
                HttpResponse.status(500, it.toString())
            }, {
                HttpResponse.noContent()
            })
    }
}
