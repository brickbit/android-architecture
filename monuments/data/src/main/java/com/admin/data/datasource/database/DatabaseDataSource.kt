package com.admin.data.datasource.database

import com.admin.domain.model.MonumentItemDto
import com.admin.domain.model.MonumentListDto

interface DatabaseDataSource{
    suspend fun getMonumentList(): MonumentListDto
    suspend fun getMonumentItem(): MonumentItemDto
}