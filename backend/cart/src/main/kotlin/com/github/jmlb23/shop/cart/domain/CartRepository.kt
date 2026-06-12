package com.github.jmlb23.shop.cart.domain

import com.github.jmlb23.shop.Either
import java.util.UUID

interface CartRepository {
    suspend fun create(id: UUID): Either<CartError, UUID>
    suspend fun delete(id: UUID): Either<CartError, UUID>
    suspend fun addProduct(
        id: UUID,
        productPayload: ProductPayload
    ): Either<CartError, UUID>
}
