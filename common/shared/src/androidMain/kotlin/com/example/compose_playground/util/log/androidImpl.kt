package com.example.compose_playground.util.log

import com.example.compose_playground.util.log.Priority.*

internal actual fun logImpl(
    priority: Priority,
    tag: String,
    msg: String
) {
    when (priority) {
        VERBOSE -> {
            android.util.Log.v(tag, msg)
        }
        DEBUG -> {
            android.util.Log.d(tag, msg)
        }
        INFO -> {
            android.util.Log.i(tag, msg)
        }
        WARN -> {
            android.util.Log.w(tag, msg)
        }
        ERROR -> {
            android.util.Log.e(tag, msg)
        }
    }
}
