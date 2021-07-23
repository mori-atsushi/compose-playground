package com.example.compose_playground.util.log

internal actual fun logImpl(
    priority: Priority,
    tag: String,
    msg: String
) {
    logDefault(priority, tag, msg)
}