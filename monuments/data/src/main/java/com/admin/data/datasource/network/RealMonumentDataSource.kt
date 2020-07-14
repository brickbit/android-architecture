package com.admin.data.datasource.network

import com.admin.data.api.ApiService
import com.admin.domain.model.MonumentItemDto
import com.admin.domain.model.MonumentListDto
import io.reactivex.Observable

class RealMonumentDataSource(private val apiservice: ApiService): NetworkDataSource {

    companion object {
        const val STATUS_ERROR = "ERROR"
    }

    override fun getMonumentItem(id: Long): Observable<MonumentItemDto> = apiservice.getMonumentItem(id)

    override fun getMonumentList(): Observable<MonumentListDto> = apiservice.getMonumentList()
}