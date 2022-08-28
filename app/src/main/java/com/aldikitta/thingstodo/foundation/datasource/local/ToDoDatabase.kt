package com.aldikitta.thingstodo.foundation.datasource.local

import androidx.room.*
import com.aldikitta.thingstodo.foundation.datasource.local.model.ToDoGroupDb
import com.aldikitta.thingstodo.foundation.datasource.local.model.ToDoStepDb

@Database(
    entities = [
        ToDoGroupDb::class,
        ToDoListDb::class,
        ToDoTaskDb::class,
        ToDoTaskFtsDb::class,
        ToDoStepDb::class
    ],
    version = 2,
    autoMigrations = [
        AutoMigration(from = 1, to = 2)
    ],
)

@TypeConverters(DateConverter::class)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun todoWriteDao(): ToDoWriteDao
}