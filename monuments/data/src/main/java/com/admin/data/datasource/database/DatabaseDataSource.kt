package com.admin.data.datasource.database

import com.admin.domain.model.MonumentDetailDomain
import com.admin.domain.model.MonumentMainListDomain

interface DatabaseDataSource{
    suspend fun getMonumentList(): MonumentMainListDomain
    suspend fun getMonumentItem(): MonumentDetailDomain
}