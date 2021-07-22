package com.example.compose_playground.desktop

import com.example.compose_playground.Greeting
import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize

fun greet(): String {
    return Greeting().greeting()
}

fun main() {
    Window(
        title = "Compose for Desktop",
        size = IntSize(600, 600)
    ) {
        App()
    }
}

@Composable
fun App() {
    MaterialTheme {
        Surface {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = greet()
                )
            }
        }
    }
}
