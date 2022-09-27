package com.aldikitta.thingstodo.features.localized.setting.data

import com.aldikitta.thingstodo.model.Language
import kotlinx.coroutines.flow.Flow

interface LocalizedSettingEnvironmentRepository {
    fun getLanguage(): Flow<Language>
    suspend fun setLanguage(language: Language)
}