package com.github.jmlb23.shop.product.domain

interface ProductRepository {
    fun get(id: String): Product
}
