import org.jetbrains.compose.compose

plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.compose") version Versions.composeJb
}

android {
    compileSdk = 30
    defaultConfig {
        applicationId = "com.example.compose_playground.android"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":common:compose-ui"))

    // androidx
    implementation(Deps.Androidx.appcompat)
    implementation(Deps.Androidx.Activity.compose)

    implementation(compose.runtime)
}
