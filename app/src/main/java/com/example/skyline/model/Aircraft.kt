package com.example.skyline.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class AircraftState(
    val icao24: String,
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

@Entity(tableName = "FAA_DATA")
data class FaaData(
    @PrimaryKey @ColumnInfo(name = "icao24") val icao24: String,
    @ColumnInfo(name = "owner_name") val ownerName: String?,
    @ColumnInfo(name = "registration_city") val registrationCity: String?,
    @ColumnInfo(name = "registration_state") val registrationState: String?,
    @ColumnInfo(name = "aircraft_make") val aircraftMake: String?,
    @ColumnInfo(name = "aircraft_model") val aircaftModel: String?,
    @ColumnInfo(name = "year_manufactured") val yearOfManufacture: String?,
    @ColumnInfo(name = "air_worthy_date") val airWorthyDate: String?,
    @ColumnInfo(name = "weight_class") val weightClass: String?,
    @ColumnInfo(name = "number_of_engines") val numberOfEngines: String?,
    @ColumnInfo(name = "number_of_seats") val numberOfSeats: String?,
    @ColumnInfo(name = "engine_category") val engineClass: String?,
    @ColumnInfo(name = "engine_make") val engineMake: String?,
    @ColumnInfo(name = "engine_model") val engineModel: String?,
    @ColumnInfo(name = "horsepower") val engineHorsepower: String?,
    @ColumnInfo(name = "thrust") val engineThrust: String?
)