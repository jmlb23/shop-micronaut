package com.github.jmlb23.shop.product.domain

import java.util.UUID
import java.util.Date

data class Product(
    val id: UUID,
    val name: String,
    val description: String,
    val price: Double,
    val createdAt: Date,
)
