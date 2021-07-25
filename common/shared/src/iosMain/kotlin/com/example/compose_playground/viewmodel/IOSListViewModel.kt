package com.example.compose_playground.viewmodel

class IOSListViewModel(
    private val viewModel: ListViewModel
) {
    val initialState: ListViewModel.State
        get() = viewModel.state.value

    fun observeState(f: (ListViewModel.State) -> Unit) {
        viewModel.state.observe(viewModel, f)
    }

    fun action(action: ListViewModel.Action) {
        viewModel.action(action)
    }

    fun clear() {
        viewModel.clear()
    }
}
