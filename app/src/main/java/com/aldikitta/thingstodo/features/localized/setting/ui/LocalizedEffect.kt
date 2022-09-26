package com.aldikitta.thingstodo.features.localized.setting.ui

import com.aldikitta.thingstodo.model.Language

sealed class LocalizedEffect {
    data class ApplyLanguage(val language: Language) : LocalizedEffect()
}
