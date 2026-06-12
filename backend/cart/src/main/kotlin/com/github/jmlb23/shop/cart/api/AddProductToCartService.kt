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

data class Payload(
    val cartId: UUID,
    val request: AddProductRequest
)

@Serdeable
data class AddProductRequest(
    val productId: UUID,
    val quantity: Int
)

@Serdeable
data class ProductQuantity(val productId: UUID, val quantity: Int)

@Serdeable
data class AddProductResponse(
    val cartId: UUID,
    val item: ProductQuantity
)

@Singleton
class AddProductToCartService(
    @Inject val repo: CartRepository
) : Service<Payload, CartError, AddProductResponse> {
    override suspend fun execute(
        param: Payload
    ): Either<CartError, AddProductResponse> {
        return repo.addProduct(
            param.cartId, 
            ProductPayload(
                param.request.productId,
                param.request.quantity
            )
        ).map {
            AddProductResponse(
                it,
                ProductQuantity(
                    param.request.productId,
                    param.request.quantity
                )
            )
        }
    }
}
