plugins {
    id("org.springframework.boot") version "2.7.1-SNAPSHOT"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"

    kotlin("jvm")
    kotlin("plugin.spring")
}

group = "com.pokemon.list"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":app"))

    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")

    implementation("io.projectreactor.netty:reactor-netty")

    implementation("io.netty:netty-all:4.1.77.Final")

    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    implementation(kotlin("stdlib"))

    implementation("io.github.microutils:kotlin-logging-jvm:2.1.23")

}