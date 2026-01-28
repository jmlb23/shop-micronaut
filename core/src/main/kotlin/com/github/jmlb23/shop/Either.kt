package com.github.jmlb23.shop

sealed class Either<out L, out R> {
    data class Left<out L>(val left: L) : Either<L, Nothing>()
    data class Right<out R>(val right: R) : Either<Nothing, R>()

    inline fun fold(onLeft: (L) -> Unit, onRight: (R) -> Unit) {
        when (this) {
            is Left -> onLeft(this.left)
            is Right -> onRight(this.right)
        }
    }
}
