package com.admin.data.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MonumentMainItemRoom(
        @PrimaryKey val id: Long,
        @ColumnInfo val title: String,
        @ColumnInfo val geocoordinates: String)
