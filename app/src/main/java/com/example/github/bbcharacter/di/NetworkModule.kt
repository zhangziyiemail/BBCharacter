package com.example.github.bbcharacter.di

import com.example.github.bbcharacter.network.BBService
import com.example.github.bbcharacter.network.RequestInterceptor
import com.example.github.bbcharacter.network.httpLoggingInterceptor
import com.example.github.bbcharacter.utils.LogUtils
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.skydoves.sandwich.coroutines.CoroutinesResponseCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *   Created by Lee Zhang on 12/1/20 21:54
 **/
val networkModule = module {

    single {
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .addInterceptor(httpLoggingInterceptor)
            .addNetworkInterceptor(StethoInterceptor())
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl(
                "https://breakingbadapi.com/api/"
            )
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutinesResponseCallAdapterFactory())
            .build()
    }

    single { get<Retrofit>().create(BBService::class.java) }
}