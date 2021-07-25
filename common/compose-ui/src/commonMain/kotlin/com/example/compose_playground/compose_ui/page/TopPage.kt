package com.example.compose_playground.compose_ui.page

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.compose_playground.compose_ui.widget.RepoList
import com.example.compose_playground.compose_util.getViewModel
import com.example.compose_playground.viewmodel.TopViewModel

@Composable
fun TopPage() {
    val viewModel = getViewModel<TopViewModel>(Unit)
    val output by viewModel.output.collectAsState()
    RepoList(output.repoList)
}
