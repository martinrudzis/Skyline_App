package com.example.skyline.mockdata

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.skyline.data.AircraftRepository
import com.example.skyline.data.AppContainer
import com.example.skyline.data.Repository
import com.example.skyline.database.FaaDatabaseService
import com.example.skyline.network.OpenSkyApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


class TestAppContainer(url: String, context: Context) : AppContainer {

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

    private val databaseService: FaaDatabaseService by lazy {
        Room.databaseBuilder(
            context.applicationContext,
            FaaDatabaseService::class.java,
            "FaaAircraftData-db"
        ).build()
    }

    override val aircraftRepository: Repository by lazy {
        AircraftRepository(retrofitService, databaseService)
    }

}