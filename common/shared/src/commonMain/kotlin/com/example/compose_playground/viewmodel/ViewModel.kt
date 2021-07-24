package com.example.compose_playground.viewmodel

abstract class ViewModel {
    private val bagOfTags: HashMap<String, Closeable> = hashMapOf()

    open fun onCleared() {
    }

    fun clear() {
        bagOfTags.forEach {
            it.value.close()
        }
        onCleared()
    }

    fun <T : Closeable> setTagIfAbsent(key: String, value: T): T {
        val previous: T? = getTag(key)
        if (previous == null) {
            bagOfTags[key] = value
        }
        return previous ?: value
    }

    fun <T : Closeable> getTag(key: String): T? {
        val result = bagOfTags[key] ?: return null
        @Suppress("UNCHECKED_CAST")
        return result as T
    }
}
