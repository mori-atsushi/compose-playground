package com.example.compose_playground.web.compose_ui.widget

import androidx.compose.runtime.Composable
import com.example.compose_playground.model.Repo
import org.jetbrains.compose.common.foundation.layout.Box
import org.jetbrains.compose.common.foundation.layout.Column
import org.jetbrains.compose.common.material.Text

@Composable
internal fun RepoList(
    repoList: List<Repo>
) {
    Column {
        repoList.forEach {
            RepoRow(it)
        }
    }
}

@Composable
internal fun RepoRow(
    repo: Repo
) {
    Box {
        Text(text = repo.name)
    }
}
