package com.example.skyline.data

import com.example.skyline.model.AircraftState
import com.example.skyline.network.OpenSkyApiService
import kotlinx.serialization.json.*

interface AircraftRepository {
    suspend fun getAircraftStates(): List<AircraftState>?
}

class NetworkAircraftRepository(
    private val openSkyApiService: OpenSkyApiService
) : AircraftRepository {
    override suspend fun getAircraftStates(): List<AircraftState>? {
        val aircraftStatesList = openSkyApiService.getStates().states?.map {
            AircraftState (
                icao24 = it[0].toString().removeSurrounding("\"")
                    .takeUnless { it == "null" },
                callsign = it[1].toString().removeSurrounding("\"").trimEnd()
                    .takeUnless { it == "null" },
                originCountry = it[2].toString().removeSurrounding("\"")
                    .takeUnless { it == "null" },
                longitude = it[5].jsonPrimitive.floatOrNull,
                latitude = it[6].jsonPrimitive.floatOrNull,
                onGround = it[8].jsonPrimitive.booleanOrNull,
                velocity = it[9].jsonPrimitive.floatOrNull,
                trueTrack = it[10].jsonPrimitive.floatOrNull,
                geoAltitude = it[13].jsonPrimitive.floatOrNull,
                category = it[17].jsonPrimitive.intOrNull
            )
        }
        return aircraftStatesList
    }
}