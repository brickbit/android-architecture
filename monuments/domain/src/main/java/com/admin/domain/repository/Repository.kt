package com.admin.domain.repository

import com.admin.domain.model.Either
import com.admin.domain.model.MonumentDetailDomain
import com.admin.domain.model.MonumentMainListDomain
import com.admin.domain.model.Result

interface Repository {
    suspend fun getMonumentList(refreshStrategy: RefreshStrategy): Either<Result.Error, MonumentMainListDomain>

    suspend fun getMonumentItem(id: Long, refreshStrategy: RefreshStrategy): Either<Result.Error, MonumentDetailDomain>

}