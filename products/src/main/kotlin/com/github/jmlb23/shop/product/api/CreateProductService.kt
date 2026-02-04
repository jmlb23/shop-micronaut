package com.github.jmlb23.shop.product.api

import com.github.jmlb23.shop.Either
import com.github.jmlb23.shop.Service
import com.github.jmlb23.shop.product.domain.Product
import com.github.jmlb23.shop.product.domain.ProductError
import com.github.jmlb23.shop.product.domain.ProductRepository
import io.micronaut.serde.annotation.Serdeable
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.util.Date
import java.util.UUID

@Serdeable
data class CreateProduct(
    val name: String,
    val description: String,
    val price: Double
)

@Serdeable
data class CreatedProductResponse(
    val id: UUID,
    val name: String,
    val description: String,
    val price: Double,
    val created: Date
)

@Singleton
class CreateProductService(@Inject val repository: ProductRepository) :
        Service<UUID, ProductError, CreatedProductResponse> {
    fun Product.toDTO() = CreatedProductResponse(id, name, description, price, createdAt)

    override suspend fun execute(
            param: UUID
    ): Either<ProductError, CreatedProductResponse> {
        return repository.get(param).map { it.toDTO() }
    }
}
