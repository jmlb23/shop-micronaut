package com.github.jmlb23.shop.product.api

import com.github.jmlb23.shop.Service
import com.github.jmlb23.shop.Either
import com.github.jmlb23.shop.product.domain.ProductError
import com.github.jmlb23.shop.product.domain.ProductRepository
import com.github.jmlb23.shop.product.domain.Product
import com.github.jmlb23.shop.product.domain.ProductUpdate
import io.micronaut.serde.annotation.Serdeable
import java.util.UUID
import java.util.Date
import java.math.BigDecimal
import jakarta.inject.Singleton


@Singleton
class UpdateProductByIdSerive(
    val repo: ProductRepository
) : Service<UpdateProductByIdSerive.Request, ProductError, UUID> {
    data class ProductUpdatePayload(
        val description: String?,
        val name: String?,
        val price: BigDecimal
    )
    data class Request(val idToUpdate: UUID, val payload: ProductUpdatePayload)

    override suspend fun execute(param: Request): Either<ProductError, UUID> =
        repo.update(
            ProductUpdate(
                param.idToUpdate,
                param.payload.name,
                param.payload.description,
                param.payload.price.toDouble()
            )
        )
    }
}
