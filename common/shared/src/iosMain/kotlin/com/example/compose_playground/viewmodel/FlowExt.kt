package com.example.compose_playground.viewmodel

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

internal fun <T> Flow<T>.observe(parent: ViewModel, f: (T) -> Unit) {
    this
        .onEach { f(it) }
        .launchIn(parent.viewModelScope)
}
