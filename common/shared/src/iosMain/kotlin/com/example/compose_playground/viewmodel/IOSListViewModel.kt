package com.example.compose_playground.viewmodel

class IOSListViewModel(
    private val viewModel: ListViewModel
) {
    val initialOutput: ListViewModel.Output
        get() = viewModel.output.value

    fun observe(f: (ListViewModel.Output) -> Unit) {
        viewModel.output.observe(viewModel, f)
    }

    fun input(input: ListViewModel.Input) {
        viewModel.input(input)
    }

    fun clear() {
        viewModel.clear()
    }
}
