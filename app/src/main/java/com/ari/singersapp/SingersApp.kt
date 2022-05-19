package com.ari.singersapp

import android.app.Application
import com.ari.singersapp.di.modules.appModule
import com.ari.singersapp.di.modules.domainModule
import com.ari.singersapp.di.modules.repoModule
import com.ari.singersapp.di.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class SingersApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SingersApp)
            modules(listOf(appModule, repoModule, viewModelModule, domainModule))
        }

    }
}
