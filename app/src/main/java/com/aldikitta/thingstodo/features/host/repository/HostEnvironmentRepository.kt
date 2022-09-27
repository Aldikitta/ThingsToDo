package com.aldikitta.thingstodo.features.host.repository

import com.aldikitta.thingstodo.model.Theme
import kotlinx.coroutines.flow.Flow

interface HostEnvironmentRepository {
    fun getTheme(): Flow<Theme>
}