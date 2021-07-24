package com.example.compose_playground.compose_util

import com.example.compose_playground.viewmodel.ViewModel

class ViewModelRegistry : androidx.lifecycle.ViewModel() {
    private val bagOfTags: HashMap<String, ViewModel> = hashMapOf()

    fun <T : ViewModel> setTagIfAbsent(key: String, value: T): T {
        val previous: T? = getTag(key)
        if (previous == null) {
            bagOfTags[key] = value
        }
        return previous ?: value
    }

    fun <T : ViewModel> getTag(key: String): T? {
        val result = bagOfTags[key] ?: return null
        @Suppress("UNCHECKED_CAST")
        return result as T
    }

    fun removeTag(key: String) {
        bagOfTags.remove(key)
    }

    override fun onCleared() {
        bagOfTags.forEach {
            it.value.clear()
        }
    }
}
