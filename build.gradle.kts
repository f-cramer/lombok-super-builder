plugins {
    id("java")
}

group = "io.github.f-cramer"
version = "1.0-SNAPSHOT"

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")
}

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}
