package com.example.skyline.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Aircraft(
    val latitude: Float?,
    val longitude: Float?,
    val velocity: Float?,
    @SerialName(value = "geo_altitude")
    val altitude: Float?,
    @SerialName(value = "true_track")
    val direction: Float?,
    @SerialName(value = "origin_country")
    val countryOfOrigin: String
)
