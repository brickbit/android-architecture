package com.admin.data.datasource.network

import com.admin.data.api.ApiService
import com.admin.domain.model.Either
import com.admin.domain.model.MonumentItemDomain
import com.admin.domain.model.MonumentListDomain
import com.admin.domain.model.Result

class NetworkDataSourceImpl(private val apiservice: ApiService): NetworkDataSource {

    override suspend fun getMonumentItem(id: Long): Either<Result.Error, MonumentItemDomain> = execute {
        apiservice.getMonumentItem(id)
    }

    override suspend fun getMonumentList(): Either<Result.Error, MonumentListDomain> = execute {
        apiservice.getMonumentList()
    }
}