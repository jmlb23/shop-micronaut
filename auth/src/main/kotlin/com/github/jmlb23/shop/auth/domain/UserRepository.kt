package com.github.jmlb23.shop.auth.domain

import com.github.jmlb23.shop.Either

interface UserRepository {
    suspend fun login(username: String, password: String): Either<AuthDomainError, String> 
}
