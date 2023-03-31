package com.example.skyline.mockdata

import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.example.skyline.model.AircraftState
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import java.io.File

val JSON_FILE = File("src\\main\\assets\\ExampleOpenSkyApiResponse2.json")

class FakeWebService() {

    fun getAircraftStateListFromSimulatedOpenSkyNetworkApi() : List<AircraftState>?
    {
        val fakeWebServer = MockWebServer()
        fakeWebServer.start()
        val testAppContainer = TestAppContainer(
            fakeWebServer.url("/").toString(),
            getApplicationContext()
        )
        val response = MockResponse()
            .setBody(JSON_FILE.readText())
        fakeWebServer.enqueue(response)

        var aircraftStateList: List<AircraftState>?

        runBlocking {
            aircraftStateList = testAppContainer.aircraftRepository.getAircraftStates()
        }

        fakeWebServer.shutdown()
        return aircraftStateList
    }

}
//        val server = MockWebServer()
//        server.start()
//        val response = MockResponse()
//            .setBody(File("src\\main\\assets\\ExampleOpenSkyApiResponse2.json").readText())
//        server.enqueue(response)
//        val testApp = TestAppContainer(server.url("/").toString())
//
//        runBlocking {
//            val aircraftStateList = testApp.aircraftRepository.getAircraftStates()
//            val firstAircraftState = aircraftStateList[0]
//            assert(
//                firstAircraftState.icao24.equals("44022b"),
//                { "firstAircraftState icao24 is actually ${firstAircraftState.icao24}" }
//            )
//            assert(
//                firstAircraftState.callsign.equals("AUA5M"),
//                { "firstAircraftState callsign is actually ${firstAircraftState.callsign}" }
//            )
//            assert(
//                firstAircraftState.originCountry.equals("Austria"),
//                { "firstAircraftState country is actually ${firstAircraftState.originCountry}" }
//            )
//        }
//
//        // println("**** $response ***")
//
//        server.shutdown()
//    }
//}