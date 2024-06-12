package com.jhebler.run.presentation.active_run.maps

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.ColorUtils
import com.jhebler.core.domain.location.LocationTimestamp
import kotlin.math.abs

object PolylineColorCalculator {

    fun locationsToColor(location1: LocationTimestamp, location2: LocationTimestamp): Color {
        val distanceFeet = location1.location.location.distanceTo(location2.location.location)
        val timeDiff = abs((location2.durationTimestamp - location1.durationTimestamp).inWholeSeconds)
        val speedMilesPerHr = (distanceFeet / timeDiff) * 0.681818

        return interpolateColor(
            speedMilesPerHr = speedMilesPerHr,
            minSpeed = 3.0, //Avg walking speed
            maxSpeed = 13.0, //Avg running speed
            colorStart = Color.Red,
            colorMid = Color.Yellow,
            colorEnd = Color.Green
        )
    }

    private fun interpolateColor(
        speedMilesPerHr: Double,
        minSpeed: Double,
        maxSpeed: Double,
        colorStart: Color,
        colorMid: Color,
        colorEnd: Color
    ): Color {
        val ratio = ((speedMilesPerHr - minSpeed) / (maxSpeed - minSpeed)).coerceIn(0.0..1.0)
        val colorInt = if(ratio <= 0.5) {
            val midRatio = ratio / 0.5
            ColorUtils.blendARGB(colorStart.toArgb(), colorMid.toArgb(), midRatio.toFloat())
        } else {
            val midToEndRatio = (ratio - 0.5) / 0.5
            ColorUtils.blendARGB(colorMid.toArgb(), colorEnd.toArgb(), midToEndRatio.toFloat())
        }

        return Color(colorInt)
    }
}