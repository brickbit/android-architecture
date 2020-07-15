package com.admin.data.datasource.network

import com.admin.domain.model.Either
import com.admin.domain.model.MonumentItemDomain
import com.admin.domain.model.MonumentListDomain
import com.admin.domain.model.Result

interface NetworkDataSource {
    suspend fun getMonumentList(): Either<Result.Error, MonumentListDomain>
    suspend fun getMonumentItem(id: Long): Either<Result.Error, MonumentItemDomain>
}