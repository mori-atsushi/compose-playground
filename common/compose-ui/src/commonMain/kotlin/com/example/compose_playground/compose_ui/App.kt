package com.example.compose_playground.compose_ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.compose_playground.Greeting
import com.example.compose_playground.compose_ui.di.get
import com.example.compose_playground.viewmodel.TopViewModel

@Composable
fun App() {
    val viewModel: TopViewModel = get(Unit)
    DisposableEffect(Unit) {
        onDispose {
            viewModel.clear()
        }
    }
    MaterialTheme {
        Surface {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = Greeting().greeting()
                )
            }
        }
    }
}