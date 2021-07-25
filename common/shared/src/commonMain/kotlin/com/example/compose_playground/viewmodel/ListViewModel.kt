package com.example.compose_playground.viewmodel

import com.example.compose_playground.model.Repo
import com.example.compose_playground.network.GitHubApi
import com.example.compose_playground.util.log.Log
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ListViewModel(
    private val gitHubApi: GitHubApi
) : ViewModel() {
    companion object {
        private const val TAG = "TopViewModel"
    }

    private val _state = MutableStateFlow(State.initial)
    val state: StateFlow<State> = _state

    private val submitEvent = MutableSharedFlow<Unit>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    init {
        submitEvent
            .onEach {
                try {
                    val userName = state.value.userName
                    val repoList = gitHubApi.getRepoList(userName)
                    _state.value = _state.value.copy(
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

    fun action(action: Action) {
        when (action) {
            is Action.Submit -> submit()
            is Action.SetUserName -> setUserName(action)
        }
    }

    private fun submit() {
        viewModelScope.launch {
            submitEvent.emit(Unit)
        }
    }

    private fun setUserName(action: Action.SetUserName) {
        _state.value = _state.value.copy(
            userName = action.userName
        )
    }

    data class State(
        val userName: String,
        val repoList: List<Repo>
    ) {
        companion object {
            val initial: State
                get() = State(
                    userName = "Google",
                    repoList = emptyList()
                )
        }
    }

    sealed class Action {
        object Submit : Action()
        data class SetUserName(val userName: String) : Action()
    }
}
