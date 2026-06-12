package com.github.jmlb23.shop.cart.domain

sealed class CartError {
    data object NotFoundError: CartError()
    data class AddProductError(val error: Throwable) : CartError()
    data class CreateCartError(val error: Throwable) : CartError()
    data class UnknownError(val error: Throwable): CartError() {
        override fun toString() = error.stackTraceToString()
    }
}
