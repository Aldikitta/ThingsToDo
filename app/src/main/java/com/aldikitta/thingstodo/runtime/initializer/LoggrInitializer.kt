package com.aldikitta.thingstodo.runtime.initializer

import android.content.Context
import androidx.startup.Initializer
import com.aldikitta.core_logger.Logger
import com.aldikitta.test_debug.DebugTools
import com.aldikitta.thingstodo.foundation.analytic.crash.CrashLogging

class LoggerInitializer : Initializer<Logger> {
    override fun create(context: Context): Logger {
        val loggings = DebugTools.getLoggings().toMutableList()
        loggings.add(CrashLogging())
        Logger.initialize(loggings)
        return Logger
    }

//    override fun dependencies(): MutableList<Class<out Initializer<*>>> = emptyList()
    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}