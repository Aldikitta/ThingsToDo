package com.aldikitta.thingstodo.runtime.initializer

import android.content.Context
import androidx.startup.Initializer
import com.aldikitta.test_debug.DebugTools

class DebugToolsInitializer : Initializer<DebugTools> {
    override fun create(context: Context): DebugTools {
        DebugTools.init()
        return DebugTools
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
