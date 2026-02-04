package com.github.jmlb23.shop.product.domain


sealed class ProductError {
    data object NotFoundError: ProductError()
}
