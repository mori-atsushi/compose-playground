package com.example.compose_playground.util.log

internal actual fun logImpl(
    priority: Priority,
    tag: String,
    msg: Any?
) {
    logDefault(priority, tag, msg)
}