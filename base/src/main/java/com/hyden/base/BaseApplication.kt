package com.hyden.base

import android.app.Application
import com.hyden.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

abstract class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(listOf(networkModule))
        }
    }
}