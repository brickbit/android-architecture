package com.admin.monuments.di

import android.content.Context
import com.admin.data.BuildConfig
import com.admin.data.api.ApiService
import com.admin.data.datasource.database.DatabaseDataSource
import com.admin.data.datasource.database.RealDabaseDataSource
import com.admin.data.datasource.network.NetworkDataSource
import com.admin.data.datasource.network.RealMonumentDataSource
import com.admin.data.datasource.network.createService
import com.admin.data.repository.CommonMonumentRepository
import com.admin.domain.constants.BuildType
import com.admin.domain.constants.buildType
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.singleton
import com.admin.domain.executor.Executor
import com.admin.domain.interactor.monuments.GetMonumentItemUseCase
import com.admin.domain.interactor.monuments.GetMonumentListUseCase
import com.admin.domain.repository.MonumentRepository
import com.admin.monuments.error.ErrorHandler
import com.admin.monuments.error.AndroidErrorHandler
import com.admin.monuments.executor.RxExecutor
import com.github.salomonbrys.kodein.instance

/**
 * Modules
 */
fun appModule(context: Context) = Kodein.Module {
    bind<Context>() with singleton { context }
    bind<Executor>() with singleton { RxExecutor() }
    bind<ErrorHandler>() with singleton { AndroidErrorHandler(context = context) }

    bind<BuildType>() with singleton { buildType(BuildConfig.BUILD_TYPE) }

}

val domainModule = Kodein.Module {
    bind() from singleton { GetMonumentListUseCase(repository = instance(), executor = instance()) }
    bind() from singleton { GetMonumentItemUseCase(repository = instance(), executor = instance()) }

    // Add here data dependencies
}

val dataModule = Kodein.Module {
    //Database
    bind<DatabaseDataSource>() with singleton { RealDabaseDataSource() }

    //Api Services
    bind<ApiService>() with singleton {
        createService<ApiService>(buildType = instance(), endPoint = ApiService.ENDPOINT)
    }
    //Data Sources
    bind<NetworkDataSource>() with singleton { RealMonumentDataSource(apiservice = instance()) }

    //Repository
    bind<MonumentRepository>() with singleton { CommonMonumentRepository(network = instance()/*, database = instance()*/) }
    // Add here data dependencies
}