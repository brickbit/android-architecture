package com.admin.domain.repository

import com.admin.domain.model.MonumentItemDto
import com.admin.domain.model.MonumentListDto
import io.reactivex.Observable

interface MonumentRepository {
    fun getMonumentList(refreshStrategy: RefreshStrategy): Observable<MonumentListDto>

    fun getMonumentItem(id: Long, refreshStrategy: RefreshStrategy): Observable<MonumentItemDto>

}