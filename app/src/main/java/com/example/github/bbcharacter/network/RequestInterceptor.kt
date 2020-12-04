package com.example.github.bbcharacter.network

import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber

/**
 *   Created by Lee Zhang on 12/1/20 21:55
 **/
class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder().url(originalRequest.url).build()
        Timber.d(request.toString())
        return chain.proceed(request)
    }
}
