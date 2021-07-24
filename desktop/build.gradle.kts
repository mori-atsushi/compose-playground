import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform") // kotlin("jvm") doesn't work well in IDEA/AndroidStudio (https://github.com/JetBrains/compose-jb/issues/22)
    id("org.jetbrains.compose") version Versions.composeJb
}

kotlin {
    jvm {
        withJava()
    }
    sourceSets {
        named("jvmMain") {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation(project(":common:compose-ui"))
                implementation(project(":common:shared"))
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.example.compose_playground.desktop.MainKt"
    }
}
