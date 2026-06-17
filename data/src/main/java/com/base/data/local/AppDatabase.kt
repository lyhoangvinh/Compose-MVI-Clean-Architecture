package com.base.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

// Add entities = [YourEntity::class] as you create them
@Database(entities = [BaseEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase()
