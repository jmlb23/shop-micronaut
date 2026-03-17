package com.github.jmlb23.blog.application

import io.micronaut.runtime.Micronaut
import io.micronaut.runtime.Micronaut.run

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License

@OpenAPIDefinition(
   info = Info(
       title = "Shop API",
       version = "1.0.0",
       description = "shop api",
       license = License(name = "GPLv3", url = "https://www.gnu.org/licenses/gpl-3.0.en.html#license-text"),
   )
)
object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        run(*args)
    }
}
