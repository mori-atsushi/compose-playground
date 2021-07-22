pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "ComposePlayground"
include(":androidApp")
include(":shared")
include(":desktop")
include(":compose-ui")
