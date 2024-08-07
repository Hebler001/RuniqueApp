package com.jhebler.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jhebler.core.database.dao.AnalyticsDao
import com.jhebler.core.database.dao.RunDao
import com.jhebler.core.database.dao.RunPendingSyncDao
import com.jhebler.core.database.entity.DeletedRunSyncEntity
import com.jhebler.core.database.entity.RunEntity
import com.jhebler.core.database.entity.RunPendingSyncEntity

@Database(
    entities = [
        RunEntity::class,
        RunPendingSyncEntity::class,
        DeletedRunSyncEntity::class
               ],
    version = 1
)
abstract class RunDatabase: RoomDatabase() {
    abstract val runDao: RunDao
    abstract val runPendingSyncDao: RunPendingSyncDao
    abstract val analyticsDao: AnalyticsDao
}