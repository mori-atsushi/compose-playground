package com.example.compose_playground.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

private const val COROUTINE_SCOPE_KEY = "kotlinx.coroutines.CoroutineScope"

val ViewModel.viewModelScope: CoroutineScope
    get() {
        val scope: CoroutineScope? = this.getTag(COROUTINE_SCOPE_KEY)
        if (scope != null) {
            return scope
        }
        return setTagIfAbsent(
            COROUTINE_SCOPE_KEY,
            CloseableCoroutineScope()
        )
    }

private class CloseableCoroutineScope(
    context: CoroutineContext = SupervisorJob() + Dispatchers.Main.immediate
) : Closeable, CoroutineScope {
    override val coroutineContext: CoroutineContext = context

    override fun close() {
        coroutineContext.cancel()
    }
}
