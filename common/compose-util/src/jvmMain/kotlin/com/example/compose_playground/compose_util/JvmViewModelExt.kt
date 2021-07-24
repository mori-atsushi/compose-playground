package com.example.compose_playground.compose_util

import androidx.compose.runtime.Composable
import com.example.compose_playground.viewmodel.ViewModel

@Composable
actual inline fun <reified T : ViewModel> getViewModel(key: Any?): T {
    return getViewModelDefault(key)
}
