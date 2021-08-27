package com.ereldev.mcureleasedates.business.common

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import kotlinx.serialization.json.Json

object HttpClientFactory {

    fun buildClient() = HttpClient {
        install(JsonFeature) {
            val json = Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            }

            serializer = KotlinxSerializer(json)
        }
    }

}