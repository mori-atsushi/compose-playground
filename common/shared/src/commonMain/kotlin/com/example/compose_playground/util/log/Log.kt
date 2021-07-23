package com.example.compose_playground.util.log

object Log {
    fun v(tag: String, msg: Any?) {
        logImpl(Priority.VERBOSE, tag, msg)
    }

    fun d(tag: String, msg: Any?) {
        logImpl(Priority.DEBUG, tag, msg)
    }

    fun i(tag: String, msg: Any?) {
        logImpl(Priority.INFO, tag, msg)
    }

    fun w(tag: String, msg: Any?) {
        logImpl(Priority.WARN, tag, msg)
    }

    fun e(tag: String, msg: Any?) {
        logImpl(Priority.ERROR, tag, msg)
    }
}
