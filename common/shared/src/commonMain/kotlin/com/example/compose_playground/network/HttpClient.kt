package com.example.compose_playground.network

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kotlinx.serialization.json.Json

internal fun createHttpClient(): HttpClient {
    val json = Json {
        ignoreUnknownKeys = true
    }
    val kotlinxSerializer = KotlinxSerializer(json)
    return HttpClient {
        install(JsonFeature) {
            serializer = kotlinxSerializer
        }
    }
}