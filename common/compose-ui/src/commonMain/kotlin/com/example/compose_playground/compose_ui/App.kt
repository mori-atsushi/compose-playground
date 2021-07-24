package com.example.compose_playground.compose_ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.compose_playground.Greeting
import com.example.compose_playground.compose_ui.di.get
import com.example.compose_playground.network.GitHubApi
import com.example.compose_playground.util.log.Log

@Composable
fun App() {
    val api: GitHubApi = get(Unit)
    LaunchedEffect(Unit) {
        val response = api.getRepoList("Google")
        Log.d("Sample", response)
    }
    MaterialTheme {
        Surface {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = Greeting().greeting()
                )
            }
        }
    }
}