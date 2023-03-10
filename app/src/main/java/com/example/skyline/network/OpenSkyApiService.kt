package com.example.skyline.network

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*
import retrofit2.http.GET

interface OpenSkyApiService {
    @GET("states")
    suspend fun getStates(): OpenSkyApiResponse
}

@Serializable
data class OpenSkyApiResponse(
    val time: Int?,
    val states: List<List<JsonElement>>?
)


