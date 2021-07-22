package com.example.compose_playground

import kotlinx.browser.window

actual class Platform {
    private val userAgent: String
        get() = window.navigator.userAgent

    actual val platform: String
        get() = "Web {$userAgent)"
}