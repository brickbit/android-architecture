package com.admin.data.datasource.network

import com.admin.data.api.ApiService
import com.admin.domain.model.Either
import com.admin.domain.model.MonumentDetailDomain
import com.admin.domain.model.MonumentMainListDomain
import com.admin.domain.model.Result

class NetworkDataSourceImpl(private val apiService: ApiService): NetworkDataSource {

    override suspend fun getMonumentItem(id: Long): Either<Result.Error, MonumentDetailDomain> = execute {
        apiService.getMonumentItem(id)
    }

    override suspend fun getMonumentList(): Either<Result.Error, MonumentMainListDomain> = execute {
        apiService.getMonumentList()
    }
}