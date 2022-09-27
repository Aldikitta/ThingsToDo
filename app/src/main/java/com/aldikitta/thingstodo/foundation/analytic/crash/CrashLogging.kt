package com.aldikitta.thingstodo.foundation.analytic.crash

import android.util.Log
import com.aldikitta.core_logger.Logging
import com.google.firebase.crashlytics.FirebaseCrashlytics

class CrashLogging : Logging {
    override fun log(priority: Int, tag: String, message: String, throwable: Throwable?) {
        if (priority == Log.ASSERT) {
            FirebaseCrashlytics.getInstance().log(message)
            if (throwable != null) {
                FirebaseCrashlytics.getInstance().recordException(throwable)
            }
        }
    }
}