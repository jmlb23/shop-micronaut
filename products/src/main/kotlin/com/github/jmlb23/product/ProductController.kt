package com.github.jmlb23.product

import com.github.jmlb23.product.dto.*
import io.micronaut.http.HttpStatus
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.http.annotation.Status
import java.util.UUID
import java.util.Date
import jakarta.inject.Inject

@Controller("/product")
class ProductController(){

    @Get("/") 
    @Produces(MediaType.APPLICATION_JSON) 
    fun index() = mapOf("hola" to "mundo")

    @Post("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Status(HttpStatus.CREATED)
    fun addProducts(@Body prod: CreateProduct): HttpResponse<CreatedProductResponse> {
        return HttpResponse.ok(
            CreatedProductResponse(
                UUID.randomUUID().toString(), 
                prod.name, 
                prod.description, 
                prod.price,
                Date()
            )
        ).header("location", "/product/${UUID.randomUUID().toString()}")
    }
}
