package com.github.jmlb23.shop.product.infra

import com.github.jmlb23.shop.Either
import com.github.jmlb23.shop.product.domain.Product
import com.github.jmlb23.shop.product.domain.ProductError
import com.github.jmlb23.shop.product.domain.ProductRepository
import io.micronaut.data.annotation.Repository 
import io.micronaut.data.repository.kotlin.CoroutineCrudRepository
import java.util.Date
import java.util.UUID

@Repository
abstract class DataProductRepositoryImp : ProductRepository, CoroutineCrudRepository<JPAProduct, String>{

    override suspend fun get(id: String): Either<ProductError, Product> {
        return find(id)?.let { 
            Either.fromRight(Product(UUID.fromString(it.id), it.name, it.description, it.price, it.createdAt))
        } ?: Either.fromLeft(ProductError.NotFoundError)
    }

    suspend fun find(id: String): JPAProduct?
}
