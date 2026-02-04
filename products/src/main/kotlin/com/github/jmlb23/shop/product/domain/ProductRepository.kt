package com.github.jmlb23.shop.product.domain

import com.github.jmlb23.shop.Either
import java.util.UUID

interface ProductRepository {
    suspend fun get(id: UUID): Either<ProductError,Product>
}
