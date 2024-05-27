package com.jhebler.auth.data.di

import com.jhebler.auth.data.EmailPatternValidator
import com.jhebler.auth.domain.PatternValidator
import com.jhebler.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
}