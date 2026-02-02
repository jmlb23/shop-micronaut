package com.github.jmlb23.shop.auth.api

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Request(val username: String, val password: String)

@Serdeable
data class Response(val token: String)
