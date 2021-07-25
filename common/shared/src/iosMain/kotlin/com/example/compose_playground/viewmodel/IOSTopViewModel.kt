package com.example.compose_playground.viewmodel

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class IOSTopViewModel(
    private val viewModel: TopViewModel
) {
    fun observe(f: (TopViewModel.Output) -> Unit) {
        viewModel.output
            .onEach { f(it) }
            .launchIn(viewModel.viewModelScope)
    }

    fun clear() {
        viewModel.clear()
    }
}
