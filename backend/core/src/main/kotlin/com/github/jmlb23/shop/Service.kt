package com.github.jmlb23.shop


interface Service<in I, out E, out O> {
    suspend fun execute(param: I): Either<E, O>
}
