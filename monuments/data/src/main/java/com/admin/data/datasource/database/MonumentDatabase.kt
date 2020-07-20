package com.admin.data.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.admin.data.datasource.database.dao.MonumentDao
import com.admin.data.model.database.MonumentMainItemRoom

@Database(entities = [MonumentMainItemRoom::class], version = 1)
abstract class MonumentDatabase : RoomDatabase() {

    abstract fun monumentDao(): MonumentDao

}