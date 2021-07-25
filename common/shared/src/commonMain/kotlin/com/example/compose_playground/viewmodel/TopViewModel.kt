package com.example.compose_playground.viewmodel

import com.example.compose_playground.model.Repo
import com.example.compose_playground.network.GitHubApi
import com.example.compose_playground.util.log.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TopViewModel(
    private val gitHubApi: GitHubApi
) : ViewModel() {
    companion object {
        private const val TAG = "TopViewModel"
    }

    private val _output = MutableStateFlow(Output())
    val output: StateFlow<Output> = _output

    init {
        viewModelScope.launch {
            try {
                val repoList = gitHubApi.getRepoList("Google")
                _output.value = Output(
                    repoList = repoList
                )
            } catch (e: Throwable) {
                Log.e(TAG, e)
            }
        }
    }

    data class Output(
        val repoList: List<Repo> = emptyList()
    )
}
