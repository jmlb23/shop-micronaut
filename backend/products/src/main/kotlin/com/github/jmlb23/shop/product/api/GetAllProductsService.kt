package com.github.jmlb23.shop.product.api

import com.github.jmlb23.shop.Either
import com.github.jmlb23.shop.Service
import com.github.jmlb23.shop.product.domain.Product
import com.github.jmlb23.shop.product.domain.ProductError
import com.github.jmlb23.shop.product.domain.ProductRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton
import io.micronaut.serde.annotation.Serdeable
import java.util.UUID
import java.util.Date

@Serdeable
data class ProductDTO(val id: UUID, val name: String, val description: String, val price: Double, val createdAt: Date)



@Singleton
class GetAllProductsService(@Inject val repository: ProductRepository) :
        Service<Unit, ProductError, List<ProductDTO>> {
    fun Product.toDTO() = 
        ProductDTO(id, name, description, price, createdAt)

    override suspend fun execute(param: Unit): Either<ProductError, List<ProductDTO>> {
        return repository.all().map { it.map { it.toDTO() }}
    }
}
