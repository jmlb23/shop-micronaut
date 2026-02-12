package com.github.jmlb23.shop.auth.domain

import java.util.UUID

data class User(val id: UUID, val name: String, val hashedPassword: String)
