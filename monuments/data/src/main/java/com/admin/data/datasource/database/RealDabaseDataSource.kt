package com.admin.data.datasource.database

import com.admin.domain.model.MonumentItemDto
import com.admin.domain.model.MonumentListDto
import io.reactivex.Observable

class RealDabaseDataSource: DatabaseDataSource {
    override fun getMonumentList(): Observable<MonumentListDto> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMonumentItem(): Observable<MonumentItemDto> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}