plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.plugin.allopen")
    id("com.google.devtools.ksp")
    id("io.micronaut.library")
    id("com.gradleup.shadow")
    id("io.micronaut.aot")
}


version = "0.1"

val kotlinVersion=project.properties.get("kotlinVersion")

dependencies {
    implementation(project(":core"))
    ksp("io.micronaut:micronaut-http-validation")
    ksp("io.micronaut.serde:micronaut-serde-processor")
    ksp("io.micronaut.openapi:micronaut-openapi")
    implementation("io.micronaut.openapi:micronaut-openapi-annotations")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    compileOnly("io.micronaut:micronaut-http-client")
    runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
    testImplementation("io.micronaut:micronaut-http-client")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
 
    implementation("io.micronaut.security:micronaut-security")
    implementation("org.springframework.security:spring-security-crypto:6.2.0")
    implementation("org.slf4j:jcl-over-slf4j")
    annotationProcessor("io.micronaut.security:micronaut-security-annotations")
    implementation("io.micronaut.security:micronaut-security-jwt")
    aotPlugins(platform("io.micronaut.platform:micronaut-platform:4.10.7"))
    aotPlugins("io.micronaut.security:micronaut-security-aot")
}

java {
    sourceCompatibility = JavaVersion.toVersion("21")
}



graalvmNative.toolchainDetection = false


micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.github.jmlb23.shop.*")
    }
    aot {
        // Please review carefully the optimizations enabled below
        // Check https://micronaut-projects.github.io/micronaut-aot/latest/guide/ for more details

        optimizeServiceLoading = false
        convertYamlToJava = false
        precomputeOperations = true
        cacheEnvironment = true
        optimizeClassLoading = true
        deduceEnvironment = true
        optimizeNetty = true
        replaceLogbackXml = true
    }
}
