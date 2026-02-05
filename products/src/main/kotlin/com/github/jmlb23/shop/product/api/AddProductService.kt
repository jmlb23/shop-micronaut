package com.github.jmlb23.shop.product.api

import com.github.jmlb23.shop.Service
import com.github.jmlb23.shop.Either
import com.github.jmlb23.shop.product.domain.ProductError
import com.github.jmlb23.shop.product.domain.ProductRepository
import com.github.jmlb23.shop.product.domain.Product
import io.micronaut.serde.annotation.Serdeable
import java.util.UUID
import java.util.Date

@Serdeable
data class CreateProductDTO(val name: String, val description: String, val price: Double)

class AddProductSerive(val repo: ProductRepository) : Service<CreateProductDTO, ProductError, UUID> {
    override suspend fun execute(param: CreateProductDTO): Either<ProductError, UUID> {
        return repo.add(Product(
            UUID.randomUUID(),
            param.name,
            param.description,
            param.price,
            Date()
        ))
    }
}


