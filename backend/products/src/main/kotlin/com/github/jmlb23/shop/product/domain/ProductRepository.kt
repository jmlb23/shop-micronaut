package com.github.jmlb23.shop.product.domain

import com.github.jmlb23.shop.Either
import com.github.jmlb23.shop.product.domain.ProductUpdate
import java.util.UUID

interface ProductRepository {
    suspend fun get(id: UUID): Either<ProductError,Product>
    suspend fun all(): Either<ProductError, List<Product>>
    suspend fun add(product: Product): Either<ProductError, UUID>
    suspend fun delete(id: UUID): Either<ProductError, UUID>
    suspend fun update(payload: ProductUpdate): Either<ProductError, UUID>
}
