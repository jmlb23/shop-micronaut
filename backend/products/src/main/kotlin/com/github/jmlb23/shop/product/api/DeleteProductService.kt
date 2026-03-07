package com.github.jmlb23.shop.product.api

import com.github.jmlb23.shop.Service
import com.github.jmlb23.shop.Either
import com.github.jmlb23.shop.product.domain.ProductError
import com.github.jmlb23.shop.product.domain.ProductRepository
import com.github.jmlb23.shop.product.domain.Product
import io.micronaut.serde.annotation.Serdeable
import java.util.UUID
import java.util.Date
import jakarta.inject.Singleton


@Singleton
class DeleteProductSerive(
    val repo: ProductRepository
) : Service<UUID, ProductError, UUID> {
    override suspend fun execute(param: UUID): Either<ProductError, UUID> {
        return repo.delete(param)
    }
}


