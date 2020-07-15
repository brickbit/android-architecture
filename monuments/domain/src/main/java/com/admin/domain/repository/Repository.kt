package com.admin.domain.repository

import com.admin.domain.model.Either
import com.admin.domain.model.MonumentItemDomain
import com.admin.domain.model.MonumentListDomain
import com.admin.domain.model.Result

interface Repository {
    suspend fun getMonumentList(refreshStrategy: RefreshStrategy): Either<Result.Error, MonumentListDomain>

    suspend fun getMonumentItem(id: Long, refreshStrategy: RefreshStrategy): Either<Result.Error, MonumentItemDomain>

}