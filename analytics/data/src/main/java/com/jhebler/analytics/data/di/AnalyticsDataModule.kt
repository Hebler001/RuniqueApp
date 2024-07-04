package com.jhebler.analytics.data.di

import com.jhebler.analytics.data.RoomAnalyticsRepository
import com.jhebler.analytics.domain.AnalyticsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsModule = module {
    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
}