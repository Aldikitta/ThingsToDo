package com.aldikitta.thingstodo.runtime.initializer

import android.content.Context
import androidx.startup.Initializer
import com.aldikitta.core_logger.ActivityLifecycleLogger
import com.aldikitta.thingstodo.runtime.ThingsTodoApp

class ActivityLifecycleLoggrInitializer : Initializer<ActivityLifecycleLogger> {
    override fun create(context: Context): ActivityLifecycleLogger {
        return ActivityLifecycleLogger().also {
            (context.applicationContext as ThingsTodoApp)
                .registerActivityLifecycleCallbacks(it)
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = listOf(LoggerInitializer::class.java)
}
