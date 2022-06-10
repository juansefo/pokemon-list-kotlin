plugins {
    kotlin("jvm")
}

group = "com.pokemon.list"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation (platform("io.projectreactor:reactor-bom:2020.0.18"))
    implementation( "io.projectreactor.kotlin:reactor-kotlin-extensions")
}