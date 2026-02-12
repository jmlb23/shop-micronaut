package com.github.jmlb23.shop

sealed class Either<out L, out R> {
    data class Left<out L>(val left: L) : Either<L, Nothing>()
    data class Right<out R>(val right: R) : Either<Nothing, R>()

    companion object {
        fun <L,R> fromLeft(left: L): Either<L,R> = Either.Left(left)
        fun <L, R> fromRight(right: R): Either<L,R> = Either.Right(right)
    }
    inline fun <T> map(f: (R) -> T): Either<L, T> {
        return when (this) {
            is Right -> Either.fromRight<L, T>(f(this.right))
            is Left -> Either.fromLeft<L, T>(this.left)
        }
    }


    inline fun forEach(onLeft: (L) -> Unit, onRight: (R) -> Unit) {
        when (this) {
            is Left -> onLeft(this.left)
            is Right -> onRight(this.right)
        }
    }

    inline fun <T> fold(onLeft: (L) -> T, onRight: (R) -> T): T {
        return when (this) {
            is Left -> onLeft(this.left)
            is Right -> onRight(this.right)
        }
    }
}
