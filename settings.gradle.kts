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
include(":desktop")
include(":common:shared")
include(":common:compose-ui")
