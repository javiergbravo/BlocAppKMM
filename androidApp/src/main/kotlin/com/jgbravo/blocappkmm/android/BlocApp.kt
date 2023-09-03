package com.jgbravo.blocappkmm.android

import android.app.Application
import com.jgbravo.blocappkmm.android.di.androidModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BlocApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BlocApp)
            androidLogger()
            modules(androidModule)
        }
    }
}