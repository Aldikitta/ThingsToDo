package com.aldikitta.thingstodo.features.host.data

import com.aldikitta.thingstodo.foundation.datasource.preferences.PreferenceManager
import com.aldikitta.thingstodo.model.Theme
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HostEnvironment @Inject constructor(
    private val preferenceManager: PreferenceManager
) : IHostEnvironment {
    override fun getTheme(): Flow<Theme> {
        TODO("Not yet implemented")
    }
}