package com.admin.monuments.di

import android.content.Context
import androidx.room.Room
import com.admin.data.BuildConfig
import com.admin.data.api.ApiService
import com.admin.data.datasource.database.DatabaseDataSource
import com.admin.data.datasource.database.DabaseDataSourceImpl
import com.admin.data.datasource.database.MonumentDatabase
import com.admin.data.datasource.database.dao.MonumentDao
import com.admin.data.datasource.network.NetworkDataSource
import com.admin.data.datasource.network.NetworkDataSourceImpl
import com.admin.data.datasource.network.createService
import com.admin.data.repository.RepositoryImpl
import com.admin.domain.constants.BuildType
import com.admin.domain.constants.buildType
import com.admin.domain.repository.Repository
import com.admin.monuments.error.ErrorHandler
import com.admin.monuments.error.AndroidErrorHandler
import com.admin.monuments.executor.CoroutinesExecutor
import com.admin.monuments.executor.Executor
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.eagerSingleton
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

/**
 * Modules
 */
fun appModule(context: Context) = Kodein.Module("App") {
    bind<Context>() with singleton { context }
    bind<Executor>() with singleton { CoroutinesExecutor() }
    bind<ErrorHandler>() with singleton { AndroidErrorHandler(context = context) }
    bind<BuildType>() with singleton { buildType(BuildConfig.BUILD_TYPE) }
    bind<MonumentDatabase>() with singleton { Room.databaseBuilder(
            context,
            MonumentDatabase::class.java,
            "monument-db"
    ).build()}
}

val domainModule = Kodein.Module("Domain") {
    // Add here data dependencies
}

val dataModule = Kodein.Module("Data") {
    //Database
    bind<DatabaseDataSource>() with singleton { DabaseDataSourceImpl() }

    //Api Services
    bind<ApiService>() with singleton {
        createService<ApiService>(buildType = instance(), endPoint = ApiService.ENDPOINT)
    }
    //Data Sources
    bind<NetworkDataSource>() with singleton { NetworkDataSourceImpl(apiService = instance()) }
    //Repository
    bind<Repository>() with singleton { RepositoryImpl(network = instance(), database = instance()) }
    // Add here data dependencies
}