package com.admin.data.datasource.network

import com.admin.domain.model.Either
import com.admin.domain.model.MonumentDetailDomain
import com.admin.domain.model.MonumentMainListDomain
import com.admin.domain.model.Result

interface NetworkDataSource {
    suspend fun getMonumentList(): Either<Result.Error, MonumentMainListDomain>
    suspend fun getMonumentItem(id: Long): Either<Result.Error, MonumentDetailDomain>
}