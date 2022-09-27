package com.aldikitta.thingstodo.features.splash.repository

import com.aldikitta.thingstodo.model.Credential
import kotlinx.coroutines.flow.Flow

interface SplashEnvironmentRepository {
    fun getCredential(): Flow<Credential>
}