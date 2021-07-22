import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose") version Versions.composeJb
}

kotlin {
    android()
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(project(":common:shared"))
            }
        }
    }
}

android {
    compileSdk = 30

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 30
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}