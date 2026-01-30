package com.github.jmlb23.shop.product.api

import com.github.jmlb23.shop.Either
import com.github.jmlb23.shop.Service
import com.github.jmlb23.shop.product.domain.Product
import com.github.jmlb23.shop.product.domain.ProductError
import com.github.jmlb23.shop.product.domain.ProductRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class CreateProductService(@Inject val repository: ProductRepository) :
        Service<String, ProductError, Product> {

    override suspend fun execute(param: String): Either<ProductError, Product> {
        return repository.get(param)
    }
}
