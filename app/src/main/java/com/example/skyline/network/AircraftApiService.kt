package com.example.skyline.network

import com.example.skyline.model.Aircraft
import retrofit2.http.GET

interface AircraftApiService {
    @GET(value = "aircraft")
    suspend fun getAircraft(): List<Aircraft>
}