package com.example.skyline.database

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Query
import androidx.room.RoomDatabase
import com.example.skyline.model.FaaData

@Dao
interface FaaDataDao {
    @Query("SELECT * FROM `FAA_DATA` WHERE icao24 IS :icao24")
    fun getAircraftFaaDataByIcao24(icao24: String?) : FaaData?
}

@Database(entities = [FaaData::class], version = 1)
abstract class FaaDatabaseService : RoomDatabase() {
    abstract fun getFaaData(): FaaDataDao
}