package com.example.compose_playground.network

import com.example.compose_playground.model.User
import com.example.compose_playground.util.log.Log
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

object Sample {
    fun sample() {
        val json = Json {
            ignoreUnknownKeys = true
        }
        val client = HttpClient {
            install(JsonFeature) {
                serializer = KotlinxSerializer(json)
            }
        }
        GlobalScope.launch {
            val response: User = client.get("https://api.github.com/users/google")
            Log.d("Sample", response)
        }
    }
}
