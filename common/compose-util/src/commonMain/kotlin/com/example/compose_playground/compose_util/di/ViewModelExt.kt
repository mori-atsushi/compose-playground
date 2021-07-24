package com.example.compose_playground.compose_util.di

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import com.example.compose_playground.viewmodel.ViewModel

@Composable
inline fun <reified T : ViewModel> getViewModel(
    key: Any?
): T {
    val viewModel: T = get(key)
    DisposableEffect(Unit) {
        onDispose {
            viewModel.clear()
        }
    }
    return viewModel
}
