package com.github.jmlb23.shop.product.infra

import com.github.jmlb23.shop.Either
import com.github.jmlb23.shop.product.domain.Product
import com.github.jmlb23.shop.product.domain.ProductError
import com.github.jmlb23.shop.product.domain.ProductRepository
import jakarta.inject.Singleton
import java.util.Date
import java.util.UUID

@Singleton
class InMemoryProductRepositoryImp : ProductRepository {
    override suspend fun get(id: String): Either<ProductError, Product> {
        return Either.Right(Product(UUID.fromString(id), "Example", "a description", 2.3, Date()))
    }
}
