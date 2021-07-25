package com.example.compose_playground.viewmodel

class IOSTopViewModel(
    private val viewModel: TopViewModel
) {
    fun observe(f: (TopViewModel.Output) -> Unit) {
        viewModel.output.observe(viewModel, f)
    }

    fun clear() {
        viewModel.clear()
    }
}
