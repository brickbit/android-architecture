package com.admin.data.api

import com.admin.data.BuildConfig
import com.admin.domain.constants.Constants.Companion.endpointUrl
import com.admin.domain.constants.buildType
import com.admin.domain.model.MonumentItemDomain
import com.admin.domain.model.MonumentListDomain
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    companion object {
        val ENDPOINT = endpointUrl(buildType(BuildConfig.BUILD_TYPE))
    }

    @GET("/points")
    suspend fun getMonumentList(): MonumentListDomain

    @GET("/points/{id}")
    suspend fun getMonumentItem(@Path("id")id:Long): MonumentItemDomain
}