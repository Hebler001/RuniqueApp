package com.jhebler.run.network

import com.jhebler.core.domain.location.Location
import com.jhebler.core.domain.run.Run
import java.time.Instant
import java.time.ZoneId
import kotlin.time.Duration.Companion.milliseconds

fun RunDto.toRun(): Run {
    return Run(
        id = id,
        duration = durationMillis.milliseconds,
        dateTimeUtc = Instant.parse(dateTimeUtc)
            .atZone(ZoneId.of("UTC")),
        distanceFeet = (distanceMeters * METER_FEET_RATIO).toInt(),
        location = Location(lat, long),
        maxSpeedMilesPerHr = maxSpeedKmh * KILOMETER_MILE_RATIO,
        totalElevationFeet = (totalElevationMeters * METER_FEET_RATIO).toInt(),
        mapPictureUrl = mapPictureUrl
    )
}

fun Run.toCreateRunRequest(): CreateRunRequest {
    return CreateRunRequest(
        id = id!!,
        durationMillis = duration.inWholeMilliseconds,
        distanceMeters = (distanceFeet / METER_FEET_RATIO).toInt(),
        lat = location.lat,
        long = location.long,
        avgSpeedKmh = avgSpeedMilesPerHr / KILOMETER_MILE_RATIO,
        maxSpeedKmh = maxSpeedMilesPerHr / KILOMETER_MILE_RATIO,
        totalElevationMeters = (totalElevationFeet / METER_FEET_RATIO).toInt(),
        epochMillis = dateTimeUtc.toEpochSecond() * 1000L
    )
}

const val METER_FEET_RATIO = 3.28084
const val KILOMETER_MILE_RATIO = 0.621371