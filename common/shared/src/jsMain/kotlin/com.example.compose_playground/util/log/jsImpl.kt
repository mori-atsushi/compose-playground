package com.example.compose_playground.util.log

internal actual fun logImpl(
    priority: Priority,
    tag: String,
    msg: Any?
) {
    val message = createLogMessage(priority, tag, msg)
    console.log(message)
}