plugins {
    id("java")
    id("com.github.ben-manes.versions") version "0.52.0"
    id("org.sonarqube") version "6.3.1.5724"
    application
    checkstyle
}

application {
    mainClass = "hexlet.code.App"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.getByName("run", JavaExec::class) {
	standardInput = System.`in`
}

tasks.test {
    useJUnitPlatform()
}

sonar {
    properties {
        property("sonar.projectKey", "DmitryCo_java-project-61")
        property("sonar.organization", "dmitryco")
    }
}
