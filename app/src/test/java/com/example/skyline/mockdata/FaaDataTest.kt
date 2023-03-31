package com.example.skyline.mockdata

import androidx.test.core.app.ApplicationProvider.getApplicationContext
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class FaaDataTest {

    val server = FakeWebService()
    val aircraftStates = server.getAircraftStateListFromSimulatedOpenSkyNetworkApi()
    val testAppContainer = TestAppContainer("http://127.0.0.1", getApplicationContext())

    @Test
    fun get_list_of_American_registered_aircraft() {
        val americanAircraft = runBlocking {
            testAppContainer.aircraftRepository.getFaaAircraftData(aircraftStates!!)
        }
        assertNotEquals(null, americanAircraft)
        americanAircraft.forEach {
            print("${it?.icao24.toString()} ")
        }
        println()
    }

}