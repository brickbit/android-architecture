package com.admin.data.datasource.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.admin.data.model.database.MonumentMainItemRoom

@Dao
interface MonumentDao {
    @Query("SELECT * FROM monumentmainitemroom")
    suspend fun getAll(): List<MonumentMainItemRoom>
}