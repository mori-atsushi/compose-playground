package com.example.compose_playground.compose_ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.compose_playground.compose_ui.widget.RepoList
import com.example.compose_playground.compose_ui.widget.SearchBox
import com.example.compose_playground.compose_util.getViewModel
import com.example.compose_playground.viewmodel.ListViewModel
import com.example.compose_playground.viewmodel.ListViewModel.Input

@Composable
fun ListPage() {
    val viewModel = getViewModel<ListViewModel>(Unit)
    val output by viewModel.output.collectAsState()
    val dispatch = viewModel::input

    Column {
        SearchBox(
            value = output.userName,
            onValueChange = {
                dispatch(Input.SetUserName(it))
            },
            onSubmit = {
                dispatch(Input.Submit)
            }
        )
        RepoList(
            repoList = output.repoList
        )
    }
}
