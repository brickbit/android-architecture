package com.admin.data.repository

import com.admin.data.datasource.network.NetworkDataSource
import com.admin.domain.model.Either
import com.admin.domain.model.MonumentItemDto
import com.admin.domain.model.MonumentListDto
import com.admin.domain.model.Result
import com.admin.domain.repository.MonumentRepository
import com.admin.domain.repository.RefreshStrategy

class CommonMonumentRepository(/*private val database: DatabaseDataSource,*/
                               private val network: NetworkDataSource): MonumentRepository {

    override suspend fun getMonumentItem(id:Long, refreshStrategy: RefreshStrategy): Either<Result.Error, MonumentItemDto> {
        return when (refreshStrategy) {
            RefreshStrategy.NETWORK_AND_SAVE_LOCAL -> network.getMonumentItem(id)//FIXME
            RefreshStrategy.LOCAL -> network.getMonumentItem(id)//FIXME
            RefreshStrategy.NETWORK -> network.getMonumentItem(id)
        }
    }

    override suspend fun getMonumentList(refreshStrategy: RefreshStrategy): Either<Result.Error, MonumentListDto> {
        return when (refreshStrategy) {
            RefreshStrategy.NETWORK_AND_SAVE_LOCAL -> network.getMonumentList()
            RefreshStrategy.LOCAL -> network.getMonumentList()
            RefreshStrategy.NETWORK -> network.getMonumentList()
        }
    }
}