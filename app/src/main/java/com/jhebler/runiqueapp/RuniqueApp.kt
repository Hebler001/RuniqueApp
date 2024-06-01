package com.jhebler.runiqueapp

import android.app.Application
import com.jhebler.auth.data.di.authDataModule
import com.jhebler.auth.presentation.di.authViewModelModule
import com.jhebler.core.data.di.coreDataModule
import com.jhebler.runiqueapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule
            )
        }
    }
}