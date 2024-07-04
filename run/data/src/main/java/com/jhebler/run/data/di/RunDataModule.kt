package com.jhebler.run.data.di

import com.jhebler.core.domain.run.SyncRunScheduler
import com.jhebler.run.data.CreateRunWorker
import com.jhebler.run.data.DeleteRunWorker
import com.jhebler.run.data.FetchRunsWorker
import com.jhebler.run.data.SyncRunWorkerScheduler
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}