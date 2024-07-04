package com.jhebler.analytics.presentation

sealed interface AnalyticsAction {
    data object OnBackClick: AnalyticsAction
}