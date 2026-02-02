package com.github.jmlb23.shop.auth.api

import com.github.jmlb23.shop.Either
import com.github.jmlb23.shop.Service
import com.github.jmlb23.shop.auth.domain.AuthDomainError
import com.github.jmlb23.shop.auth.domain.UserRepository
import jakarta.inject.Inject

class LoginService(@Inject val repository: UserRepository) :
        Service<Request, AuthDomainError, String> {


    override suspend fun execute(param: Request): Either<AuthDomainError, String> {
        return repository.login(param.username, param.password)
    }
}
