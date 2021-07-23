package com.example.compose_playground.util.log

internal expect fun logImpl(
    priority: Priority,
    tag: String,
    msg: String
)

internal fun logDefault(
    priority: Priority,
    tag: String,
    msg: String
) {
    val message = createLogMessage(priority, tag, msg)
    println(message)
}

internal fun createLogMessage(
    priority: Priority,
    tag: String,
    msg: String
): String {
    return "[${priority.label}] $tag - $msg"
}
