package com.admin.data.datasource.network

import com.admin.data.api.ApiService
import com.admin.domain.model.Either
import com.admin.domain.model.MonumentItemDto
import com.admin.domain.model.MonumentListDto
import com.admin.domain.model.Result

class RealMonumentDataSource(private val apiservice: ApiService): NetworkDataSource {

    override suspend fun getMonumentItem(id: Long): Either<Result.Error, MonumentItemDto> = execute {
        apiservice.getMonumentItem(id)
    }

    override suspend fun getMonumentList(): Either<Result.Error, MonumentListDto> = execute {
        apiservice.getMonumentList()
    }
}