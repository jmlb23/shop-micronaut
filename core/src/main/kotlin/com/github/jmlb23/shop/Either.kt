package com.github.jmlb23.shop

sealed class Either<out L, out R> {
    data class Left<out L>(val left: L) : Either<L, Nothing>()
    data class Right<out R>(val right: R) : Either<Nothing, R>()

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
