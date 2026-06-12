package com.github.jmlb23.shop.cart.infra

import com.github.jmlb23.shop.Either
import com.github.jmlb23.shop.cart.domain.CartError
import com.github.jmlb23.shop.cart.domain.CartRepository
import com.github.jmlb23.shop.cart.domain.ProductPayload
import io.micronaut.context.annotation.Requires
import jakarta.inject.Singleton
import java.util.Date
import java.util.UUID
import io.micronaut.data.annotation.Repository

@Repository
@Requires(env = ["dev"])
open class InMemoryCartRepositoryImp : CartRepository {
    
    override suspend fun create(id: UUID): Either<CartError, UUID> {
        TODO()
    }

    override suspend fun delete(id: UUID): Either<CartError, UUID> {
        TODO()
    }

    override suspend fun addProduct(
        id: UUID,
        productPayload: ProductPayload
    ): Either<CartError, UUID> {
        TODO()
    }

}
