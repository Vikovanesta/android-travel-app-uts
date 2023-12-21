package com.example.uts.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.uts.model.Travel


@Dao
interface TravelDao {
    @Upsert
    fun upsertTravel(vararg travel: Travel)

    @Delete
    fun deleteTravel(vararg travel: Travel)

    @Query("SELECT * FROM travels")
    fun getAllTravels(): List<Travel>

    @Query("SELECT * FROM travels WHERE id = :id")
    fun getTravelById(id: String): Travel

    @Query("SELECT * FROM travels WHERE originStationId = :originStationId")
    fun getTravelByOriginStationId(originStationId: String): Travel

    @Query("SELECT * FROM travels WHERE arrivalStationId = :arrivalStationId")
    fun getTravelByArrivalStationId(arrivalStationId: String): Travel
}