package com.example.compose_playground.viewmodel

class IOSTopViewModel(
    private val viewModel: TopViewModel
) {
    val initialOutput: TopViewModel.Output
        get() = viewModel.output.value

    fun observe(f: (TopViewModel.Output) -> Unit) {
        viewModel.output.observe(viewModel, f)
    }

    fun input(input: TopViewModel.Input) {
        viewModel.input(input)
    }

    fun clear() {
        viewModel.clear()
    }
}
