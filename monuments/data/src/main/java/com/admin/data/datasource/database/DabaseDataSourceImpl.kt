package com.admin.data.datasource.database

import com.admin.domain.model.MonumentDetailDomain
import com.admin.domain.model.MonumentMainListDomain

class DabaseDataSourceImpl: DatabaseDataSource {
    override suspend fun getMonumentList(): MonumentMainListDomain {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMonumentItem(): MonumentDetailDomain {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}