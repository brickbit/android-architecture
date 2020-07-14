package com.admin.data.datasource.network

import com.admin.domain.model.MonumentItemDto
import com.admin.domain.model.MonumentListDto
import io.reactivex.Observable

interface NetworkDataSource {
    fun getMonumentList(): Observable<MonumentListDto>
    fun getMonumentItem(id: Long): Observable<MonumentItemDto>
}