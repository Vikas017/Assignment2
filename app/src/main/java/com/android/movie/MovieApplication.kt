package com.android.movie

import android.app.Application
import com.android.movie.repo.di.APP_MODULE
import com.android.movie.repo.network.NETWORK_MODULE
import org.koin.core.context.startKoin

class MovieApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(APP_MODULE, NETWORK_MODULE) //network module start
        }
    }

}