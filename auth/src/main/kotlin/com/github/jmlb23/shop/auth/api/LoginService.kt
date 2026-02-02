package com.github.jmlb23.shop.auth.api

import com.github.jmlb23.shop.Either
import com.github.jmlb23.shop.Service
import com.github.jmlb23.shop.auth.domain.AuthDomainError
import com.github.jmlb23.shop.auth.domain.UserRepository
import com.github.jmlb23.shop.auth.domain.utils.PasswordEncoder
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class LoginService(@Inject val repository: UserRepository, @Inject val encoder: PasswordEncoder) :
        Service<Request, AuthDomainError, String> {

    override suspend fun execute(param: Request): Either<AuthDomainError, String> {
        return repository
                .getBy(param.username)
                .fold(
                        { Either.fromLeft(it) },
                        {
                            if (encoder.matches(param.password, it.hashedPassword))
                                    Either.fromRight(it.id.toString())
                            else Either.fromLeft(AuthDomainError.CredentialsError)
                        }
                )
    }
}
