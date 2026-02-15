package com.github.jmlb23.shop.product.infra


import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

@Entity
@Table(name = "product", schema="public")
class JPAProduct(
    @field:Id
    var id: UUID = UUID.randomUUID(),
    var name: String = "",
    var description: String = "",
    var price: Double = 0.0,
    var createdAt: Timestamp = Timestamp.valueOf(LocalDateTime.now())
)
