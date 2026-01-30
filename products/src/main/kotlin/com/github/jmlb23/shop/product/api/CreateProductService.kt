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

@Serdeable
data class ProductResponse(
        val id: String,
        val name: String,
        val description: String,
        val price: Double,
        val created: Date
)

@Singleton
class CreateProductService(@Inject val repository: ProductRepository) :
        Service<String, ProductError, ProductResponse> {
    fun Product.toDTO() = ProductResponse(id.toString(), name, description, price, createdAt)

    override suspend fun execute(
            param: String
    ): Either<ProductError, ProductResponse> {
        return repository.get(param).map { it.toDTO() }
    }
}
