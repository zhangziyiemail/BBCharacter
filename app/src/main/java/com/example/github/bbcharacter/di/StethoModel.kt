package com.example.github.bbcharacter.di

import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 *   Created by Lee Zhang on 12/2/20 21:44
 **/
val stehoModel = module {
    single {
        Stetho.initializeWithDefaults(androidContext());
    }
}