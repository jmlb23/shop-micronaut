package com.github.jmlb23.shop.product.domain

import com.github.jmlb23.shop.Either

interface ProductRepository {
    suspend fun get(id: String): Either<ProductError,Product>
}
