package com.admin.data.repository

import com.admin.data.datasource.network.NetworkDataSource
import com.admin.domain.model.Either
import com.admin.domain.model.MonumentItemDomain
import com.admin.domain.model.MonumentListDomain
import com.admin.domain.model.Result
import com.admin.domain.repository.Repository
import com.admin.domain.repository.RefreshStrategy

class RepositoryImpl(/*private val database: DatabaseDataSource,*/
                               private val network: NetworkDataSource): Repository {

    override suspend fun getMonumentItem(id:Long, refreshStrategy: RefreshStrategy): Either<Result.Error, MonumentItemDomain> {
        return when (refreshStrategy) {
            RefreshStrategy.NETWORK_AND_SAVE_LOCAL -> network.getMonumentItem(id)//FIXME
            RefreshStrategy.LOCAL -> network.getMonumentItem(id)//FIXME
            RefreshStrategy.NETWORK -> network.getMonumentItem(id)
        }
    }

    override suspend fun getMonumentList(refreshStrategy: RefreshStrategy): Either<Result.Error, MonumentListDomain> {
        return when (refreshStrategy) {
            RefreshStrategy.NETWORK_AND_SAVE_LOCAL -> network.getMonumentList()
            RefreshStrategy.LOCAL -> network.getMonumentList()
            RefreshStrategy.NETWORK -> network.getMonumentList()
        }
    }
}