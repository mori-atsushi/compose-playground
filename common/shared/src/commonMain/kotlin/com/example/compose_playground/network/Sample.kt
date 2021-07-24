package com.example.compose_playground.network

import com.example.compose_playground.util.log.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object Sample : KoinComponent {
    private val gitHubApi: GitHubApi by inject()

    fun sample() {
        GlobalScope.launch(Dispatchers.Main) {
            val response = gitHubApi.getRepoList("Google")
            Log.d("Sample", response)
        }
    }
}
