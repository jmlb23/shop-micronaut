package com.github.jmlb23.shop.cart.api

import com.github.jmlb23.shop.Either
import com.github.jmlb23.shop.Service
import com.github.jmlb23.shop.cart.domain.Cart
import com.github.jmlb23.shop.cart.domain.CartError
import com.github.jmlb23.shop.cart.domain.CartRepository
import com.github.jmlb23.shop.cart.domain.ProductPayload
import java.util.UUID
import jakarta.inject.Singleton
import io.micronaut.serde.annotation.Serdeable
import jakarta.inject.Inject


@Serdeable
data class CreateCartResponse(
    val id: UUID
)

@Singleton
class CreateCartService(
    @Inject val repo: CartRepository
) : Service<UUID, CartError, CreateCartResponse> {
    override suspend fun execute(
        param: UUID
    ): Either<CartError, CreateCartResponse> {
        return repo.create(param).map { CreateCartResponse(it) }
    }
}
