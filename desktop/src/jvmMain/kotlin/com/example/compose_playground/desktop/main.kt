package com.example.compose_playground.desktop

import androidx.compose.desktop.Window
import androidx.compose.ui.unit.IntSize
import com.example.compose_playground.compose_ui.App
import com.example.compose_playground.di.setupDI

fun main() {
    setupDI()
    Window(
        title = "Compose for Desktop",
        size = IntSize(600, 600)
    ) {
        App()
    }
}
