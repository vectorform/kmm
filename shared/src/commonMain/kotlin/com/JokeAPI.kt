package com

import com.models.Joke
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class JokeAPI {

    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    suspend fun getJoke(): Joke {
        val url = BASE_URL
        val result = client.get<String>(url)
        return Json.decodeFromString(result)
    }

    companion object {
        private const val BASE_URL = "https://v2.jokeapi.dev/joke/Any?safe-mode"
    }
}