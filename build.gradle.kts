plugins {
    id("java")
}

group = "de.mcmdev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("me.clip:placeholderapi:2.11.3")
    compileOnly("net.luckperms:api:5.4")
    compileOnly("io.papermc.paper:paper-api:1.19.3-R0.1-SNAPSHOT")
}