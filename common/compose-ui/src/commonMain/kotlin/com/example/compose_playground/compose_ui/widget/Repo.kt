package com.example.compose_playground.compose_ui.widget

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.compose_playground.model.Repo

@Composable
internal fun RepoList(
    repoList: List<Repo>
) {
    LazyColumn {
        items(repoList) {
            RepoRow(it)
        }
    }
}

@Composable
internal fun RepoRow(
    repo: Repo
) {
    Text(text = repo.name)
}
