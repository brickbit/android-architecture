package com.admin.data.datasource.database

import com.admin.data.mappers.toDomain
import com.admin.domain.model.MonumentDetailDomain
import com.admin.domain.model.MonumentMainListDomain

class DabaseDataSourceImpl(private val appDatabase: MonumentDatabase): DatabaseDataSource {
    override suspend fun getMonumentList(): MonumentMainListDomain =
            MonumentMainListDomain(list = appDatabase.monumentDao().getAll().map { it.toDomain() })


    override suspend fun getMonumentItem(): MonumentDetailDomain {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun saveMonumentItem(item: MonumentDetailDomain) {
        TODO("Not yet implemented")
    }

    override suspend fun saveMonumentList(list: MonumentMainListDomain) {
        TODO("Not yet implemented")
    }

}