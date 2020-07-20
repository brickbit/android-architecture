package com.admin.data.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MonumentDetailRoom(
        @PrimaryKey val id: Long,
        @ColumnInfo val title: String,
        @ColumnInfo val address: String,
        @ColumnInfo val transport: String,
        @ColumnInfo val email: String,
        @ColumnInfo val geocoordinates: String,
        @ColumnInfo val description: String,
        @ColumnInfo val phone: String)
