package com.example.compose_playground.util.log

internal expect fun logImpl(
    priority: Priority,
    tag: String,
    msg: Any?
)

internal fun logDefault(
    priority: Priority,
    tag: String,
    msg: Any?
) {
    val message = createLogMessage(priority, tag, msg)
    println(message)
}

internal fun createLogMessage(
    priority: Priority,
    tag: String,
    msg: Any?
): String {
    return "[${priority.label}] $tag - $msg"
}
