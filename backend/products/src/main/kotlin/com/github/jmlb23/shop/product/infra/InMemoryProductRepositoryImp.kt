package com.github.jmlb23.shop.product.infra

import com.github.jmlb23.shop.Either
import com.github.jmlb23.shop.product.domain.Product
import com.github.jmlb23.shop.product.domain.ProductError
import com.github.jmlb23.shop.product.domain.ProductRepository
import com.github.jmlb23.shop.product.domain.ProductUpdate
import jakarta.inject.Singleton
import java.util.Date
import java.util.UUID
import io.micronaut.data.annotation.Repository

open class InMemoryProductRepositoryImp : ProductRepository {
    override suspend fun get(id: UUID): Either<ProductError, Product> {
        return Either.Right(Product(id, "Example", "a description", 2.3, Date()))
    }
    override suspend fun all(): Either<ProductError, List<Product>> {
        return Either.fromRight(
            listOf(
                Product(UUID.randomUUID(), "Example", "a description", 2.3, Date()),
                Product(UUID.randomUUID(), "Example", "a description", 2.3, Date())
            )
        )
    }
    override suspend fun add(product: Product): Either<ProductError, UUID> {
        return Either.fromRight(UUID.randomUUID())
    }
    override suspend fun delete(id: UUID): Either<ProductError, UUID> {
        return Either.fromRight(id)
    }
    override suspend fun update(payload: ProductUpdate): Either<ProductError, UUID> =
        Either.fromRight(payload.id)
}
