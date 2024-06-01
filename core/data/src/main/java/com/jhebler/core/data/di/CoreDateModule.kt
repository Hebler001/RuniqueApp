package com.jhebler.core.data.di

import com.jhebler.core.data.networking.HttpClientFactory
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory().build()
    }
}