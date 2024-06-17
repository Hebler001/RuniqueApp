package com.jhebler.core.database.mappers

import com.jhebler.core.database.entity.RunEntity
import com.jhebler.core.domain.location.Location
import com.jhebler.core.domain.run.Run
import org.bson.types.ObjectId
import java.time.Instant
import java.time.ZoneId
import kotlin.time.Duration.Companion.milliseconds

fun RunEntity.toRun(): Run {
    return Run(
        id = id,
        duration = durationMillis.milliseconds,
        dateTimeUtc = Instant.parse(dateTimeUtc)
            .atZone(ZoneId.of("UTC")),
        distanceFeet = distanceFeet,
        location = Location(
            lat = latitude,
            long = longitude
        ),
        maxSpeedMilesPerHr = maxSpeedMilesPerHr,
        totalElevationFeet = totalElevationFeet,
        mapPictureUrl = mapPictureUrl
    )
}

fun Run.toRunEntity(): RunEntity {
    return RunEntity(
        id = id ?: ObjectId().toHexString(),
        durationMillis = duration.inWholeMilliseconds,
        maxSpeedMilesPerHr = maxSpeedMilesPerHr,
        dateTimeUtc = dateTimeUtc.toInstant().toString(),
        latitude = location.lat,
        longitude = location.long,
        distanceFeet = distanceFeet,
        avgSpeedMilesPerHr = avgSpeedMilesPerHr,
        totalElevationFeet = totalElevationFeet,
        mapPictureUrl = mapPictureUrl
    )
}