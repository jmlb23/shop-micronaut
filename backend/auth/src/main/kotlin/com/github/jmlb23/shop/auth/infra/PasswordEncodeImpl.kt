package com.github.jmlb23.shop.auth.infra

import com.github.jmlb23.shop.auth.domain.utils.PasswordEncoder
import jakarta.inject.Singleton
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Singleton
class PasswordEncoderImpl : PasswordEncoder {

    val delegate = BCryptPasswordEncoder()

    override fun encode(rawPassword: String): String {
        return delegate.encode(rawPassword)
    }

    override fun matches(rawPassword: String, encodedPassword: String): Boolean {
        return delegate.matches(rawPassword, encodedPassword)
    }
}
