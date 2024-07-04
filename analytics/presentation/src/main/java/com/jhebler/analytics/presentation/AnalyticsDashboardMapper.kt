package com.jhebler.analytics.presentation

import com.jhebler.analytics.domain.AnalyticsValues
import com.jhebler.core.presentation.ui.formatted
import com.jhebler.core.presentation.ui.toFormattedMiles
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlin.time.DurationUnit

fun Duration.toFormattedTotalTime(): String {
    val days = toLong(DurationUnit.DAYS)
    val hours = toLong(DurationUnit.HOURS) % 24
    val minutes = toLong(DurationUnit.MINUTES) % 60

    return "${days}d ${hours}h ${minutes}m"
}

fun AnalyticsValues.toAnalyticsDashboardState(): AnalyticsDashboardState {
    return AnalyticsDashboardState(
        totalDistanceRun = (totalDistanceRun / 5280.0).toFormattedMiles(),
        totalTimeRun = totalTimeRun.toFormattedTotalTime(),
        fastestEverRun = fastestEverRun.toFormattedMiles(),
        avgDistance = (avgDistancePerRun / 5280.0).toFormattedMiles(),
        avgPace = avgPacePerRun.seconds.formatted()
    )
}