package com.example.compose_playground.viewmodel

import com.example.compose_playground.model.Repo
import com.example.compose_playground.network.GitHubApi
import com.example.compose_playground.util.log.Log
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class TopViewModel(
    private val gitHubApi: GitHubApi
) : ViewModel() {
    companion object {
        private const val TAG = "TopViewModel"
    }

    private val _output = MutableStateFlow(Output())
    val output: StateFlow<Output> = _output

    private val submitEvent = MutableSharedFlow<Unit>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    init {
        submitEvent
            .onEach {
                try {
                    val userName = output.value.userName
                    val repoList = gitHubApi.getRepoList(userName)
                    _output.value = _output.value.copy(
                        repoList = repoList
                    )
                } catch (e: Throwable) {
                    Log.e(TAG, e)
                }
            }
            .launchIn(viewModelScope)

        viewModelScope.launch {
            submitEvent.emit(Unit)
        }
    }

    fun input(input: Input) {
        when (input) {
            is Input.Submit -> submit()
            is Input.SetUserName -> setUserName(input)
        }
    }

    private fun submit() {
        viewModelScope.launch {
            submitEvent.emit(Unit)
        }
    }

    private fun setUserName(input: Input.SetUserName) {
        _output.value = _output.value.copy(
            userName = input.userName
        )
    }

    data class Output(
        val userName: String = "Google",
        val repoList: List<Repo> = emptyList()
    )

    sealed class Input {
        object Submit : Input()
        data class SetUserName(val userName: String) : Input()
    }
}
