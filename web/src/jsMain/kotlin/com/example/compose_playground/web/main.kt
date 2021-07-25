package com.example.compose_playground.web

import com.example.compose_playground.di.setupDI
import com.example.compose_playground.web.compose_ui.App
import org.jetbrains.compose.web.renderComposable

fun main() {
    setupDI()
    renderComposable(rootElementId = "root") {
        App()
    }
}
