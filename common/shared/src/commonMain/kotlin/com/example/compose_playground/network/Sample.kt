package com.example.compose_playground.network

import com.example.compose_playground.util.log.Log
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

object Sample {
    fun sample() {
        val client = HttpClient()
        GlobalScope.launch {
            val response: HttpResponse = client.get("https://api.github.com/users/google")
            Log.d("Sample", response.status)
        }
    }
}
