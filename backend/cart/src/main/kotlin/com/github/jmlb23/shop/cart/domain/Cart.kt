package com.github.jmlb23.shop.cart.domain

import java.util.UUID

data class ProductPayload(
    val id: UUID,
    val quantity: Int
)
data class Cart(
    val id: UUID,
    val products: List<ProductPayload>
)
