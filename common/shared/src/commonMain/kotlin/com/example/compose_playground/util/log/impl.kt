package com.example.compose_playground.util.log

internal expect fun logImpl(priority: Priority, tag: String, msg: String)
