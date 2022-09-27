package com.aldikitta.thingstodo.features.host.repository

import com.aldikitta.thingstodo.foundation.datasource.preferences.PreferenceManager
import com.aldikitta.thingstodo.model.Theme
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HostEnvironmentImpl @Inject constructor(
    private val preferenceManager: PreferenceManager
) : HostEnvironmentRepository {
    override fun getTheme(): Flow<Theme> {
        return preferenceManager.getTheme()
    }
}