package com.jhebler.runiqueapp

import android.app.Application
import com.jhebler.auth.data.di.authDataModule
import com.jhebler.auth.presentation.di.authViewModelModule
import com.jhebler.core.data.di.coreDataModule
import com.jhebler.core.database.di.databaseModule
import com.jhebler.run.data.di.runDataModule
import com.jhebler.run.location.di.locationModule
import com.jhebler.run.network.di.networkModule
import com.jhebler.run.presentation.di.runPresentationModule
import com.jhebler.runiqueapp.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            workManagerFactory()
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule,
                networkModule,
                runDataModule
            )
        }
    }
}