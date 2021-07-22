package com.example.compose_playground

actual class Platform {
    private val os: String?
        get() = System.getProperty("os.name")
    private val version: String?
        get() = System.getProperty("os.version")
    private val arch: String?
        get() = System.getProperty("os.arch")

    actual val platform: String
        get() = "Desktop $os $version ($arch)"
}