package com.admin.data.datasource.network

import com.admin.domain.constants.BuildType
import com.admin.domain.constants.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * ServiceCreator
 */
inline fun <reified S> createService(buildType: BuildType, endPoint: String): S {
    val builder = OkHttpClient.Builder()
            //TODO check if in production service timeout is lower for match actions service
            .connectTimeout(Constants.DEFAULT_RETROFIT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(Constants.DEFAULT_RETROFIT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(Constants.DEFAULT_RETROFIT_TIMEOUT_SECONDS, TimeUnit.SECONDS)

    if (buildType != BuildType.RELEASE) {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(logging)
    }

    val client = builder
            .build()

    val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(endPoint)
            .build()

    return retrofit.create(S::class.java)
}