package com.admin.data.datasource.database

import com.admin.domain.model.MonumentItemDto
import com.admin.domain.model.MonumentListDto
import io.reactivex.Observable

interface DatabaseDataSource{
    fun getMonumentList(): Observable<MonumentListDto>
    fun getMonumentItem(): Observable<MonumentItemDto>
}