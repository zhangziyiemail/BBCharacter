package com.example.github.bbcharacter

import android.app.Application
import androidx.databinding.library.BuildConfig
import com.example.github.bbcharacter.di.*
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 *   Created by Lee Zhang on 12/1/20 21:53
 **/
class BBApplication  :Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BBApplication)
            modules(networkModule)
            modules(persistenceModule)
            modules(repositoryModule)
            modules(viewModelModule)
//            modules(stehoModel)

        }
        Stetho.initializeWithDefaults(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}