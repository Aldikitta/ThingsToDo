package com.aldikitta.thingstodo.features.splash.repository

import com.aldikitta.thingstodo.foundation.datasource.preferences.PreferenceManager
import com.aldikitta.thingstodo.model.Credential
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SplashEnvironmentRepositoryImpl @Inject constructor(
    private val preferenceManager: PreferenceManager
): SplashEnvironmentRepository{
    override fun getCredential(): Flow<Credential> {
        return preferenceManager.getCredential()
    }
}