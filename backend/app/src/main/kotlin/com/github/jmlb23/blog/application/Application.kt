package com.github.jmlb23.blog.application

import io.micronaut.openapi.annotation.OpenAPIInclude
import io.micronaut.runtime.Micronaut
import io.micronaut.runtime.Micronaut.run

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License
import io.swagger.v3.oas.annotations.security.SecurityScheme
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType


@OpenAPIInclude(
    classes = [
        com.github.jmlb23.shop.product.ProductController::class,
        com.github.jmlb23.shop.auth.AuthController::class,
        com.github.jmlb23.shop.cart.CartController::class
    ]
)
@SecurityScheme(
    name = "BearerAuth",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT"
)
@OpenAPIDefinition(
   info = Info(
       title = "Shop API",
       version = "1.0.0",
       description = "shop api",
       license = License(
           name = "GPLv3",
           url = "https://www.gnu.org/licenses/gpl-3.0.en.html#license-text"
       ),
   )
)
object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        run(*args)
    }
}
