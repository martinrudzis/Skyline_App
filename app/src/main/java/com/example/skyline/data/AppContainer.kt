package com.example.skyline.data



interface AppContainer {
    val aircraftRepository: AircraftRepository
}

class DefaultAppContainer : AppContainer {

    private val OPENSKY_NETWORK_URL = ""

    override val aircraftRepository: AircraftRepository by lazy {

    }

}