package com.admin.monuments.app

import android.app.Application
import com.admin.monuments.di.appModule
import com.admin.monuments.di.dataModule
import com.admin.monuments.di.domainModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

/**
 * App.
 */
class App : Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        import(appModule(this@App))
        import(domainModule)
        import(dataModule)
    }

}