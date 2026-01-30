package com.github.jmlb23.shop.product.api

import com.github.jmlb23.shop.product.domain.Product
import io.micronaut.serde.annotation.Serdeable
import java.util.Date

@Serdeable
data class CreateProduct(
    val name: String,
    val description: String,
    val price: Double
)

@Serdeable
data class CreatedProductResponse(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val created: Date
)

@Serdeable
data class ProductDTO(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val created: Date
)

fun Product.toDTO() = ProductDTO(id.toString(), name, description, price, createdAt)
