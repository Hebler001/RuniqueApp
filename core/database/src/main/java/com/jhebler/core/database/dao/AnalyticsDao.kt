package com.jhebler.core.database.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface AnalyticsDao {

    @Query("SELECT SUM(distanceFeet) FROM runentity")
    suspend fun getTotalDistance(): Int

    @Query("SELECT SUM(durationMillis) FROM runentity")
    suspend fun getTotalTimeRun(): Long

    @Query("SELECT MAX(maxSpeedMilesPerHr) FROM runentity")
    suspend fun getMaxRunSpeed(): Double

    @Query("SELECT AVG(distanceFeet) FROM runentity")
    suspend fun getAvgDistancePerRun(): Double

    @Query("SELECT AVG((durationMillis / 60000.0) / (distanceFeet / 5280.0)) FROM runentity")
    suspend fun getAvgPacePerRun(): Double
}