package com.example.compose_playground.util.log

import com.example.compose_playground.util.log.Priority.*

internal actual fun logImpl(
    priority: Priority,
    tag: String,
    msg: Any?
) {
    val message = msg.toString()
    when (priority) {
        VERBOSE -> {
            android.util.Log.v(tag, message)
        }
        DEBUG -> {
            android.util.Log.d(tag, message)
        }
        INFO -> {
            android.util.Log.i(tag, message)
        }
        WARN -> {
            android.util.Log.w(tag, message)
        }
        ERROR -> {
            android.util.Log.e(tag, message)
        }
    }
}
