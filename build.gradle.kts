plugins {
    java
    id("com.gradleup.shadow") version "8.3.0"
}

group = "com.tryfx"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://jitpack.io")
    maven("https://maven.enginehub.org/repo/") // WorldEdit/FAWE
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")
    compileOnly("com.github.CitizensDev:Citizens2:2.0.37") { isTransitive = false }
    compileOnly("com.sk89q.worldedit:worldedit-bukkit:7.3.9")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

tasks.processResources {
    filteringCharset = "UTF-8"
    filesMatching("plugin.yml") {
        expand("version" to project.version)
    }
}

tasks.shadowJar {
    archiveClassifier.set("")
}

tasks.build {
    dependsOn(tasks.shadowJar)
}
