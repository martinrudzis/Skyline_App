package com.example.skyline.mockdata

import com.example.skyline.data.AircraftRepository
import com.example.skyline.data.AppContainer
import com.example.skyline.data.NetworkAircraftRepository
import com.example.skyline.network.AircraftApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import okhttp3.MediaType.Companion.toMediaType

class MockAppContainer : AppContainer {

    private val BASE_URL = "/"

    @OptIn(ExperimentalSerializationApi::class)
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: AircraftApiService by lazy {
        retrofit.create(AircraftApiService::class.java)
    }

    override val aircraftRepository: AircraftRepository by lazy {
        NetworkAircraftRepository(retrofitService)
    }

}