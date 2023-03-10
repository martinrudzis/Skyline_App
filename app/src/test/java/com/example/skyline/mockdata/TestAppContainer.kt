package com.example.skyline.mockdata

import com.example.skyline.data.AircraftRepository
import com.example.skyline.data.AppContainer
import com.example.skyline.data.NetworkAircraftRepository
import com.example.skyline.network.OpenSkyApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


class TestAppContainer(url: String) : AppContainer {

    @OptIn(ExperimentalSerializationApi::class)
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(
            Json { ignoreUnknownKeys = true }
                .asConverterFactory("application/json".toMediaType())
        )
        .baseUrl(url)
        .build()

    private val retrofitService: OpenSkyApiService by lazy {
        retrofit.create(OpenSkyApiService::class.java)
    }

    override val aircraftRepository: AircraftRepository by lazy {
        NetworkAircraftRepository(retrofitService)
    }

}