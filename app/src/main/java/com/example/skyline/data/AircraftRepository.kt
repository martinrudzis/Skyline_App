package com.example.skyline.data

import com.example.skyline.model.Aircraft
import com.example.skyline.network.AircraftApiService

// Repository for fetching aircraft data from the OpenSky Network API
interface AircraftRepository {
    suspend fun getAircraft(): List<Aircraft>
}

class NetworkAircraftRepository(
    private val aircraftApiService: AircraftApiService
) : AircraftRepository {
    override suspend fun getAircraft(): List<Aircraft> = aircraftApiService.getPhotos()
}