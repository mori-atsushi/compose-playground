package com.example.compose_playground.compose_util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import com.example.compose_playground.viewmodel.ViewModel

@Composable
expect inline fun <reified T : ViewModel> getViewModel(
    key: Any?
): T

@Composable
@PublishedApi
internal inline fun <reified T : ViewModel> getViewModelDefault(
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
