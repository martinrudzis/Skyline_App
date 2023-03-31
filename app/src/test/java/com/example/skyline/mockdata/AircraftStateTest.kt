package com.example.skyline.mockdata

import androidx.test.core.app.ApplicationProvider
import com.example.skyline.model.AircraftState
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

//val EXPECTED_ICAO24 = null
//val EXPECTED_CALLSIGN = null
//val EXPECTED_ORIGIN_COUNTRY = null
//val EXPECTED_LONGITUDE = null
//val EXPECTED_LATITUDE = null
//val EXPECTED_ON_GROUND = null
//val EXPECTED_VELOCITY = null
//val EXPECTED_TRUE_TRACK = null
//val EXPECTED_GEO_ALTITUDE = null
//val EXPECTED_CATEGORY = null

val EXPECTED_ICAO24 = "44022b"
val EXPECTED_CALLSIGN = "AUA5M"
val EXPECTED_ORIGIN_COUNTRY = "Austria"
val EXPECTED_LONGITUDE = 8.7716F
val EXPECTED_LATITUDE = 47.4422F
val EXPECTED_ON_GROUND = false
val EXPECTED_VELOCITY = 64.71F
val EXPECTED_TRUE_TRACK = 276.39F
val EXPECTED_GEO_ALTITUDE = 1386.84F
val EXPECTED_CATEGORY = 1

@RunWith(RobolectricTestRunner::class)
class AircraftStateTest {

    val server = FakeWebService()
    val aircraftStates = server.getAircraftStateListFromSimulatedOpenSkyNetworkApi()
    val firstAircraftState: AircraftState = aircraftStates?.get(0) ?: AircraftState(
        "", null, null, null, null, null,
        null, null, null, null
    )

    @Test
    fun check_that_AircraftState_created_from_json_has_expected_icao24() {
        assertEquals(
            "Aircraft state has unexpected icao24 value",
            EXPECTED_ICAO24,
            firstAircraftState.icao24
        )
        println("✓ AircraftState has expected icao24 value")
    }

    @Test
    fun check_that_AircraftState_created_from_json_has_expected_callsign() {
        assertEquals(
            "Aircraft state has unexpected callsign value",
            EXPECTED_CALLSIGN,
            firstAircraftState.callsign
        )
        println("✓ AircraftState has expected callsign value")
    }

    @Test
    fun check_that_AircraftState_created_from_json_has_expected_origin_country() {
        assertEquals(
            "Aircraft state has unexpected origin country",
            EXPECTED_ORIGIN_COUNTRY,
            firstAircraftState.originCountry
        )
        println("✓ AircraftState has expected origin country")
    }

    @Test
    fun check_that_AircraftState_created_from_json_has_expected_origin_longitude() {
        assertEquals(
            "Aircraft state has unexpected longitude",
            EXPECTED_LONGITUDE,
            firstAircraftState.longitude
        )
        println("✓ AircraftState has expected longitude")
    }

    @Test
    fun check_that_AircraftState_created_from_json_has_expected_origin_latitude() {
        assertEquals(
            "Aircraft state has unexpected latitude",
            EXPECTED_LATITUDE,
            firstAircraftState.latitude
        )
        println("✓ AircraftState has expected latitude")
    }

    @Test
    fun check_that_AircraftState_created_from_json_has_expected_on_ground_state() {
        assertEquals(
            "Aircraft state has unexpected on ground state",
            EXPECTED_ON_GROUND,
            firstAircraftState.onGround
        )
        println("✓ AircraftState has expected on ground state")
    }

    @Test
    fun check_that_AircraftState_created_from_json_has_expected_velocity() {
        assertEquals(
            "Aircraft state has unexpected velocity",
            EXPECTED_VELOCITY,
            firstAircraftState.velocity
        )
        println("✓ AircraftState has expected velocity")
    }

    @Test
    fun check_that_AircraftState_created_from_json_has_expected_true_track() {
        assertEquals(
            "Aircraft state has unexpected true track",
            EXPECTED_TRUE_TRACK,
            firstAircraftState.trueTrack
        )
        println("✓ AircraftState has expected true track")
    }

    @Test
    fun check_that_AircraftState_created_from_json_has_expected_geo_altitude() {
        assertEquals(
            "Aircraft state has unexpected geo altitude",
            EXPECTED_GEO_ALTITUDE,
            firstAircraftState.geoAltitude
        )
        println("✓ AircraftState has expected geo altitude")
    }

    @Test
    fun check_that_AircraftState_created_from_json_has_expected_category() {
        assertEquals(
            "Aircraft state has unexpected category",
            EXPECTED_CATEGORY,
            firstAircraftState.category
        )
        println("✓ AircraftState has expected category")
    }

}
