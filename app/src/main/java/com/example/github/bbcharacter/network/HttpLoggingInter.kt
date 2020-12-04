package com.example.github.bbcharacter.network

import com.example.github.bbcharacter.utils.LogUtils
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

/**
 *   Created by Lee Zhang on 12/2/20 21:55
 **/
var httpLoggingInterceptor = HttpLoggingInterceptor(
object : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        if ((message.startsWith("{") && message.endsWith("}")) ||
            (message.startsWith("[") && message.endsWith("]"))
        )
            LogUtils.json(message)
        else
            LogUtils.verbose(message)
    }
})