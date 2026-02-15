package com.github.jmlb23.shop.product.domain


sealed class ProductError {
    data object NotFoundError: ProductError()
    data class CreationError(val error: Throwable) : ProductError()
    data class UnknownError(val error: Throwable): ProductError() {
        override fun toString() = error.stackTraceToString()
    }
}
