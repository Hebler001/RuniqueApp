package com.jhebler.analytics.data.di

import com.jhebler.analytics.data.RoomAnalyticsRepository
import com.jhebler.analytics.domain.AnalyticsRepository
import com.jhebler.core.database.RunDatabase
import com.jhebler.core.database.dao.AnalyticsDao
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsModule = module {
    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
    single {
        get<RunDatabase>().analyticsDao
    }
}