package com.example.compose_playground.viewmodel

import com.example.compose_playground.network.GitHubApi
import com.example.compose_playground.util.log.Log
import kotlinx.coroutines.launch

class TopViewModel(
    private val gitHubApi: GitHubApi
) : ViewModel() {
    init {
        viewModelScope.launch {
            val response = gitHubApi.getRepoList("Google")
            Log.d("Sample", response)
        }
    }
}
