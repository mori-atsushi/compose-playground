package com.example.compose_playground.util.log

object Log {
    fun v(tag: String, msg: String) {
        logImpl(Priority.VERBOSE, tag, msg)
    }

    fun d(tag: String, msg: String) {
        logImpl(Priority.DEBUG, tag, msg)
    }

    fun i(tag: String, msg: String) {
        logImpl(Priority.INFO, tag, msg)
    }

    fun w(tag: String, msg: String) {
        logImpl(Priority.WARN, tag, msg)
    }

    fun e(tag: String, msg: String) {
        logImpl(Priority.ERROR, tag, msg)
    }
}
