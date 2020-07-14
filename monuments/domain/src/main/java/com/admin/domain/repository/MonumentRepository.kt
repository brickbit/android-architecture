package com.admin.domain.repository

import com.admin.domain.model.Either
import com.admin.domain.model.MonumentItemDto
import com.admin.domain.model.MonumentListDto
import com.admin.domain.model.Result

interface MonumentRepository {
    suspend fun getMonumentList(refreshStrategy: RefreshStrategy): Either<Result.Error, MonumentListDto>

    suspend fun getMonumentItem(id: Long, refreshStrategy: RefreshStrategy): Either<Result.Error, MonumentItemDto>

}