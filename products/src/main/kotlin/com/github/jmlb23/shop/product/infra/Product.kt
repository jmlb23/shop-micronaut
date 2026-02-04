package com.github.jmlb23.shop.product.infra


import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.Date

@Entity
data class JPAProduct(
    @Id val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val createdAt: Date
)

