plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose") version Versions.composeJb
}

kotlin {
    android()
    jvm()
    js(IR) {
        browser()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(Deps.Koin.core)
                implementation(project(":common:shared"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Deps.Androidx.Compose.ui)
                implementation(Deps.Androidx.Activity.ktx)
                implementation(Deps.Androidx.Lifecycle.viewmodel)
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
}
