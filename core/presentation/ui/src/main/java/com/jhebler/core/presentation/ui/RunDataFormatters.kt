package com.jhebler.core.presentation.ui

import kotlin.math.pow
import kotlin.math.round
import kotlin.math.roundToInt
import kotlin.time.Duration

fun Duration.formatted(): String {
    val totalSeconds = inWholeSeconds
    val hours = String.format("%02d", totalSeconds / 3600)
    val minutes = String.format("%02d", (totalSeconds % 3600) / 60)
    val seconds = String.format("%02d", (totalSeconds % 60))

    return "$hours:$minutes:$seconds"
}

fun Double.toFormattedMiles(): String {
    return "${this.roundToDecimals(1)} mi"
}

fun Duration.toFormattedPace(distanceMiles: Double): String {
    if(this == Duration.ZERO || distanceMiles <= 0.0) {
        return "-"
    }

    val secondsPerMile = (this.inWholeSeconds / distanceMiles).roundToInt()
    val avgPaceMinutes = secondsPerMile / 60
    val avgPaceSeconds = String.format("%02d", secondsPerMile % 60)
    return "$avgPaceMinutes:$avgPaceSeconds / mi"
}

private fun Double.roundToDecimals(decimalCount: Int): Double {
    val factor = 10f.pow(decimalCount)
    return round(this * factor) / factor
}