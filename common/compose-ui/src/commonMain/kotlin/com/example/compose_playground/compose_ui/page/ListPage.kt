package com.example.compose_playground.compose_ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.compose_playground.compose_ui.widget.RepoList
import com.example.compose_playground.compose_ui.widget.SearchBox
import com.example.compose_playground.compose_util.getViewModel
import com.example.compose_playground.viewmodel.ListViewModel
import com.example.compose_playground.viewmodel.ListViewModel.Action

@Composable
fun ListPage() {
    val viewModel = getViewModel<ListViewModel>(Unit)
    val state by viewModel.state.collectAsState()
    val dispatch = viewModel::action

    Column {
        SearchBox(
            value = state.userName,
            onValueChange = {
                dispatch(Action.SetUserName(it))
            },
            onSubmit = {
                dispatch(Action.Submit)
            }
        )
        RepoList(
            repoList = state.repoList
        )
    }
}
