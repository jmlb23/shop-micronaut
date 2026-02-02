package com.github.jmlb23.shop.auth.domain

sealed class AuthDomainError {
    data object NotFoundError: AuthDomainError()
}
