package com.github.jmlb23.shop.auth.infra

import com.github.jmlb23.shop.Either
import com.github.jmlb23.shop.auth.domain.AuthDomainError
import com.github.jmlb23.shop.auth.domain.User
import com.github.jmlb23.shop.auth.domain.UserRepository
import jakarta.inject.Singleton
import java.util.UUID

@Singleton
class UserRepositoryImpl : UserRepository {
    val users = setOf(
        User(UUID.randomUUID(), "jmlb23", "\$2y\$10\$V9CcFoaKTVvSQWUgyGBd3eYimJGTJJIsMgZ9HFkDuVCU0CvRifuCq")
    )

    override suspend fun login(
            username: String,
            password: String
    ): Either<AuthDomainError, String> {
        return users.find { it.name == username && it.hashedPassword == password}?.let { 
                Either.fromRight(it.id.toString())
        } ?: Either.fromLeft(AuthDomainError.NotFoundError)
    }
}
