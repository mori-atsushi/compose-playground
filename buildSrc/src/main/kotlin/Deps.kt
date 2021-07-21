object Deps {
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
}