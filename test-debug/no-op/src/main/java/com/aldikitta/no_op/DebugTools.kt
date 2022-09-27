package com.aldikitta.no_op

import android.content.Context
import com.aldikitta.core_logger.Logging
import okhttp3.Interceptor

object DebugTools {

    fun init() {

    }

    fun getLoggings(): List<Logging> {
        return listOf()
    }

    fun getInterceptors(context: Context): List<Interceptor> {
        return listOf()
    }

}