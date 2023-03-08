package com.example.skyline.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BasicAircraftData(
    @SerialName("icao24") val hexCode: String,
    val imageUrl: String? = null, //
    @SerialName("callsign") val callSign: String? = null,
//    var aircraftMake: String? = null, // making a var for later database initialization
//    var aircraftModel: String? = null, // ditto
    @SerialName("origin_country") val originCountry: String? = null,
    @SerialName("category") val aircraftCategory: Int,
    val velocity: Float? = null,
    @SerialName("true_track") val track: Float? = null,
    val latitude: Float? = null,
    val longitude: Float? = null,
    @SerialName("geo_altitude") val geometricAltitude: Float? = null
)
@Serializable
data class CallsignApiInfo(val response: CallsignApiResponse)

@Serializable
data class CallsignApiResponse(@SerialName("flightroute") val flightRoute: FlightRoute? = null)

@Serializable
data class FlightRoute(
    @SerialName("airline") val airlineInfo: AirlineInfo,
    @SerialName("origin") val originInfo: LocationInfo,
    @SerialName("destination") val destinationInfo: LocationInfo
)
@Serializable
data class AirlineInfo(@SerialName("name") val airlineName: String)

@Serializable
data class LocationInfo(
    val country: String,
    val municipality: String,
    @SerialName("name") val airportName: String
)

data class RouteData(val callsignApiInfo: CallsignApiInfo)

data class FaaData(
    val ownerName: String,
    val registrationCity: String,
    val registrationState: String,
    val yearOfManufacture: String,
    val numberOfEngines: String,
    val numberOfSeats: String,
    val engineCategory: String,
    val engineMake: String,
    val engineModel: String,
    val horsepower: String?,
    val thrust: String?
)

// Four possible cases for Aircraft:
// 1) Basic info is available.
// 2) Basic info and FAA data are available.
// 3) Basic info and route data are available.
// 4) Basic info, FAA data, and route data are all available.
data class Aircraft(
    val basicInfo: BasicAircraftData,   // Included for all aircraft
    val faaInfo: FaaData?,  // Null if FAA aircraft data is unavailable
    val routeInfo: RouteData?   // Null if route data is unavailable/irrelevant
)