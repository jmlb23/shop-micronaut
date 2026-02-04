package com.github.jmlb23.shop.product.infra

import com.github.jmlb23.shop.Either
import com.github.jmlb23.shop.product.domain.Product
import com.github.jmlb23.shop.product.domain.ProductError
import com.github.jmlb23.shop.product.domain.ProductRepository
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.kotlin.CoroutineCrudRepository
import java.util.*

@Repository
interface ProductRepositoryImp :
    ProductRepository, CoroutineCrudRepository<JPAProduct, UUID> {

    override suspend fun get(id: UUID): Either<ProductError, Product> {
        return findById(id)?.let {
            Either.fromRight(Product(it.id, it.name, it.description, it.price, it.createdAt))
        } ?: Either.fromLeft(ProductError.NotFoundError)
    }

}
