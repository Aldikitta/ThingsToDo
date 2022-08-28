package com.aldikitta.thingstodo.features.host.data

import com.aldikitta.thingstodo.model.Theme
import kotlinx.coroutines.flow.Flow

interface IHostEnvironment {
    fun getTheme(): Flow<Theme>
}