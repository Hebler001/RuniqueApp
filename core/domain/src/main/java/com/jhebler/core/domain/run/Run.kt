package com.jhebler.core.domain.run

import com.jhebler.core.domain.location.Location
import java.time.ZonedDateTime
import kotlin.time.Duration
import kotlin.time.DurationUnit

data class Run(
    val id: String?, // null if new run
    val duration: Duration,
    val dateTimeUtc: ZonedDateTime,
    val distanceFeet: Int,
    val location: Location,
    val maxSpeedMilesPerHr: Double,
    val totalElevationFeet: Int,
    val mapPictureUrl: String?
) {
    val avgSpeedMilesPerHr: Double
        get() = (distanceFeet / 5280.0) / duration.toDouble(DurationUnit.HOURS)
}