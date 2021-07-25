package com.example.compose_playground.web.compose_ui.page

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.compose_playground.compose_util.getViewModel
import com.example.compose_playground.viewmodel.ListViewModel
import com.example.compose_playground.web.compose_ui.widget.RepoList
import com.example.compose_playground.web.compose_ui.widget.SearchBox
import org.jetbrains.compose.common.foundation.layout.Column

@Composable
internal fun ListPage() {
    val viewModel = getViewModel<ListViewModel>(Unit)
    val output by viewModel.output.collectAsState()
    val dispatch = viewModel::input
    Column {
        SearchBox(
            value = output.userName,
            onValueChange = {
                dispatch(ListViewModel.Input.SetUserName(it))
            },
            onSubmit = {
                dispatch(ListViewModel.Input.Submit)
            }
        )
        RepoList(
            repoList = output.repoList
        )
    }
}
