package com.aldikitta.thingstodo.foundation.analytic

import com.aldikitta.thingstodo.foundation.analytic.google.GoogleAnalytics
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class AnalyticManager @Inject constructor(
    private val googleAnalytics: GoogleAnalytics
): AnalyticsApi{
    override fun setUser(properties: Map<String, String>) {
        GlobalScope.launch(Dispatchers.IO) {
            googleAnalytics.setUser(properties)
        }
    }

    override fun updateUser(properties: Map<String, String>) {
        GlobalScope.launch(Dispatchers.IO) {
            googleAnalytics.updateUser(properties)
        }
    }

    override fun trackEvent(name: String) {
        GlobalScope.launch(Dispatchers.IO) {
            googleAnalytics.trackEvent(name)
        }
    }

    override fun trackEvent(name: String, properties: Map<String, String>) {
        GlobalScope.launch(Dispatchers.IO) {
            googleAnalytics.trackEvent(name, properties)
        }
    }

    override fun flush() {
        GlobalScope.launch(Dispatchers.IO) {
            googleAnalytics.flush()
        }
    }
}