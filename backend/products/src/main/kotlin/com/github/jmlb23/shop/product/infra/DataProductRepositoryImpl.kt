package com.github.jmlb23.shop.product.infra

import com.github.jmlb23.shop.Either
import com.github.jmlb23.shop.product.domain.Product
import com.github.jmlb23.shop.product.domain.ProductError
import com.github.jmlb23.shop.product.domain.ProductRepository
import com.github.jmlb23.shop.product.domain.ProductUpdate
import io.micronaut.context.annotation.Requires
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.kotlin.CoroutineCrudRepository
import java.util.*
import java.sql.Timestamp
import java.time.LocalDateTime
import java.time.ZoneId
import kotlinx.coroutines.flow.toList
import kotlin.runCatching

@Repository
@Requires(env = ["prod"])
abstract class ProductRepositoryImp :
    ProductRepository, CoroutineCrudRepository<JPAProduct, UUID> {

    override suspend fun get(id: UUID): Either<ProductError, Product> {
        return findById(id)?.let {
            Either.fromRight(Product(it.id, it.name, it.description, it.price, it.createdAt))
        } ?: Either.fromLeft(ProductError.NotFoundError)
    }
    
    override suspend fun all(): Either<ProductError, List<Product>> {
        return runCatching{
            findAll()
        }.fold({
            Either.fromRight(
                it.toList().map{
                    Product(it.id, it.name, it.description, it.price, it.createdAt)
                }
            )
        }, { 
            Either.fromLeft(ProductError.UnknownError(it)) 
        })
    }

    override suspend fun add(product: Product): Either<ProductError, UUID> {
        return runCatching {
            save(
                JPAProduct(
                product.id,
                product.name,
                product.description,
                product.price,
                Timestamp.valueOf(
                    LocalDateTime.ofInstant(product.createdAt.toInstant(), 
                    ZoneId.systemDefault())
                )
                )
            )
        }.fold({ 
            Either.fromRight(it.id)
        }, {
            Either.fromLeft(ProductError.CreationError(it))
        })
    }

    override suspend fun delete(id: UUID): Either<ProductError, UUID> {
        return runCatching{
            deleteById(id)
        }.fold({
            Either.fromRight(id)
        }, { 
            Either.fromLeft(ProductError.UnknownError(it))
        })
    }

    override suspend fun update(payload: ProductUpdate): Either<ProductError, UUID> {
        return runCatching { 
            val entity = findById(payload.id)
            entity?.let { 
                update(
                    it.copy(
                        name=payload.name ?: it.name,
                        description=payload.description ?: it.description,
                        price=payload.price ?: it.price
                    )
                )
            }
        }.fold({
            it?.let { 
                Either.fromRight(
                    it.id
                )
            } ?: Either.fromLeft(ProductError.NotFoundError)
        }, {
            Either.fromLeft(ProductError.UpdateError(it))
        })
    }
}
