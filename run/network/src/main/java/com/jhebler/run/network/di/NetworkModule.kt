package com.jhebler.run.network.di

import com.jhebler.core.domain.run.RemoteRunDataSource
import com.jhebler.run.network.KtorRemoteRunDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    singleOf(::KtorRemoteRunDataSource).bind<RemoteRunDataSource>()
}