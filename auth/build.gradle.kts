plugins {
    id("io.micronaut.library") version "4.6.1"
    id("com.gradleup.shadow") version "8.3.9"
    id("io.micronaut.aot") version "4.6.1"
}

dependencies {
    annotationProcessor("io.micronaut.security:micronaut-security-annotations")
    implementation("io.micronaut.security:micronaut-security-jwt")
    aotPlugins("io.micronaut.security:micronaut-security-aot")
}
