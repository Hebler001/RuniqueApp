package com.jhebler.core.database.di

import androidx.room.Room
import com.jhebler.core.database.RoomLocalRunDataSource
import com.jhebler.core.database.RunDatabase
import com.jhebler.core.database.dao.RunPendingSyncDao
import com.jhebler.core.domain.run.LocalRunDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            RunDatabase::class.java,
            "run.db"
        ).build()
    }
    single { get<RunDatabase>().runDao }
    single { get<RunDatabase>().runPendingSyncDao }
    singleOf(::RoomLocalRunDataSource).bind<LocalRunDataSource>()
}