package com.admin.data.datasource.database

import com.admin.domain.model.MonumentItemDomain
import com.admin.domain.model.MonumentListDomain

interface DatabaseDataSource{
    suspend fun getMonumentList(): MonumentListDomain
    suspend fun getMonumentItem(): MonumentItemDomain
}