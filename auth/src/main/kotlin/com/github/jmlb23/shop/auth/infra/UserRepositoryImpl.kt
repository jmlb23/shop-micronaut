package com.github.jmlb23.shop.auth.infra

import com.github.jmlb23.shop.Either
import com.github.jmlb23.shop.auth.domain.AuthDomainError
import com.github.jmlb23.shop.auth.domain.User
import com.github.jmlb23.shop.auth.domain.UserRepository
import com.github.jmlb23.shop.auth.domain.utils.PasswordEncoder
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.util.UUID

@Singleton
class UserRepositoryImpl : UserRepository {
    val users =
            setOf(
                    User(
                            UUID.randomUUID(),
                            "jmlb23",
                            "\$2a\$10\$LuxX.wpFOD6b3kelREzdOOXAU0inPnJBThdpBeSYd2Xix/u6MXPPW"
                    )
            )

    override suspend fun getBy(
            username: String,
    ): Either<AuthDomainError, User> {
        return users.find { it.name == username }?.let {
            Either.fromRight(it)
        } ?: Either.fromLeft(AuthDomainError.NotFoundError)
    }
}
