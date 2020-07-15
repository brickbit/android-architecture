package com.admin.data.datasource.network

import com.admin.domain.model.Either
import com.admin.domain.model.MonumentItemDto
import com.admin.domain.model.MonumentListDto
import com.admin.domain.model.Result

interface NetworkDataSource {
    suspend fun getMonumentList(): Either<Result.Error, MonumentListDto>
    suspend fun getMonumentItem(id: Long): Either<Result.Error, MonumentItemDto>
}