package com.jhebler.run.data.di

import com.jhebler.run.data.CreateRunWorker
import com.jhebler.run.data.DeleteRunWorker
import com.jhebler.run.data.FetchRunsWorker
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)
}