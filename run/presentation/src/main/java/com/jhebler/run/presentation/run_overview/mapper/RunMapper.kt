package com.jhebler.run.presentation.run_overview.mapper

import com.jhebler.core.domain.run.Run
import com.jhebler.core.presentation.ui.formatted
import com.jhebler.core.presentation.ui.toFormattedFeet
import com.jhebler.core.presentation.ui.toFormattedMiles
import com.jhebler.core.presentation.ui.toFormattedMilesPerHr
import com.jhebler.core.presentation.ui.toFormattedPace
import com.jhebler.run.presentation.run_overview.model.RunUi
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun Run.toRunUi(): RunUi {
    val dateTimeInLocalTime = dateTimeUtc
        .withZoneSameInstant(ZoneId.systemDefault())
    val formattedDateTime = DateTimeFormatter
        .ofPattern("MMM dd, yyyy - hh:mma")
        .format(dateTimeInLocalTime)

    val distanceMiles = distanceFeet / 5280.0

    return RunUi(
        id = id!!,
        duration = duration.formatted(),
        dateTime = formattedDateTime,
        distance = distanceMiles.toFormattedMiles(),
        avgSpeed = avgSpeedMilesPerHr.toFormattedMilesPerHr(),
        maxSpeed = maxSpeedMilesPerHr.toFormattedMilesPerHr(),
        pace = duration.toFormattedPace(distanceMiles),
        totalElevation = totalElevationFeet.toFormattedFeet(),
        mapPictureUrl = mapPictureUrl
    )
}