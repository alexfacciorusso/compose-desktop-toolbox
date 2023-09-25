plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    `java-library`
    `maven-publish`
}

group = "com.alexfacciorusso.compose-desktop-toolbox"

val isSnapshotBuild = project.findProperty("snapshot") == "true"

version = ("0.1.0" + if (isSnapshotBuild) "-SNAPSHOT" else "")

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xcontext-receivers")
    }
}

publishing {
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
            artifactId = "compose-desktop-toolbox"
        }
    }
}

dependencies {
    implementation(compose.desktop.common)
}
