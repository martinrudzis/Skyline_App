package com.example.skyline.data

import android.os.AsyncTask
import com.example.skyline.database.FaaDatabaseService
import com.example.skyline.model.AircraftState
import com.example.skyline.model.FaaData
import com.example.skyline.network.OpenSkyApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.*
import kotlin.concurrent.thread

interface Repository {
    suspend fun getAircraftStates(): List<AircraftState>
    suspend fun getFaaAircraftData(aircraftList: List<AircraftState>): List<FaaData?>
}

class AircraftRepository(
    private val openSkyApiService: OpenSkyApiService,
    private val faaDatabaseService: FaaDatabaseService
) : Repository {
    override suspend fun getAircraftStates(): List<AircraftState> {
        val aircraftStatesList: List<AircraftState>
        aircraftStatesList = openSkyApiService.getStates().states?.map {
            AircraftState (
                icao24 = it[0].toString().removeSurrounding("\""),
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
        }!!
        return aircraftStatesList
    }

    override suspend fun getFaaAircraftData(aircraftList: List<AircraftState>): List<FaaData?> =
        withContext(Dispatchers.IO) {
            aircraftList.filter {
                it.originCountry == "United States"
            }.map {
                faaDatabaseService.getFaaData().getAircraftFaaDataByIcao24(it.icao24.uppercase())
            }
        }

//    {
//        val faaAircraftDataList: List<FaaData?> = listOf()
//        val thread = Thread {
//            aircraftList.filter {
//                it.originCountry == "United States"
//            }.map {
//                faaDatabaseService.getFaaData().getAircraftFaaDataByIcao24(it.icao24)
//            }
//        }
//        thread.start()
//        thread.join()
//        return faaAircraftDataList
//    }
}