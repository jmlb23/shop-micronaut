package com.github.jmlb23.product.dto

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
