object Deps {
    const val kotlinCoroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"

    object Androidx {
        const val appcompat =
            "androidx.appcompat:appcompat:${Versions.Androidx.appcompat}"

        object Activity {
            const val compose =
                "androidx.activity:activity-compose:${Versions.Androidx.activity}"
        }

        object Compose {
            const val ui =
                "androidx.compose.ui:ui:${Versions.Androidx.compose}"
            const val uiTooling =
                "androidx.compose.ui:ui-tooling:${Versions.Androidx.compose}"
            const val foundation =
                "androidx.compose.foundation:foundation:${Versions.Androidx.compose}"
            const val material =
                "androidx.compose.material:material:${Versions.Androidx.compose}"
        }
    }

    object Ktor {
        const val core = "io.ktor:ktor-client-core:${Versions.ktor}"
        const val cio = "io.ktor:ktor-client-cio:${Versions.ktor}"
        const val ios = "io.ktor:ktor-client-ios:${Versions.ktor}"
        const val js = "io.ktor:ktor-client-js:${Versions.ktor}"
    }
}