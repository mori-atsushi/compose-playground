package com.example.compose_playground

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}