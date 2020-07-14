package com.admin.data.api

import com.admin.data.BuildConfig
import com.admin.domain.constants.Constants.Companion.endpointUrl
import com.admin.domain.constants.buildType
import com.admin.domain.model.MonumentItemDto
import com.admin.domain.model.MonumentListDto
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    companion object {
        val ENDPOINT = "${endpointUrl(buildType(BuildConfig.BUILD_TYPE))}"
        const val DEFAULT_SC_DEVICE = "json"
    }

    @GET("/points")
    fun getMonumentList(): Observable<MonumentListDto>

    @GET("/points/{id}")
    fun getMonumentItem(@Path("id")id:Long): Observable<MonumentItemDto>
}