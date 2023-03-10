package com.example.skyline.model

data class AircraftState(
    val icao24: String?,
    val callsign: String?,
    val originCountry: String?,
    val longitude: Float?,
    val latitude: Float?,
    val onGround: Boolean?,
    val velocity: Float?,
    val trueTrack: Float?,
    val geoAltitude: Float?,
    val category: Int?
)