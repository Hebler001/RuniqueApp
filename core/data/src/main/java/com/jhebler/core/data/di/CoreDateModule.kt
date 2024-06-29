package com.jhebler.core.data.di

import com.jhebler.core.data.auth.EncryptedSessionStorage
import com.jhebler.core.data.networking.HttpClientFactory
import com.jhebler.core.data.run.OfflineFirstRunRepository
import com.jhebler.core.domain.SessionStorage
import com.jhebler.core.domain.run.RunRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()

    singleOf(::OfflineFirstRunRepository).bind<RunRepository>()
}