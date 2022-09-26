package com.aldikitta.thingstodo.foundation.extension

import com.aldikitta.thingstodo.features.localized.setting.ui.LanguageItem
import com.aldikitta.thingstodo.model.Language

//fun Language.toLanguagePreference(): LanguagePreference {
//    return when (this) {
//        Language.ENGLISH -> LanguagePreference.ENGLISH
//        Language.INDONESIA -> LanguagePreference.INDONESIA
//    }
//}
//
//fun LanguagePreference.toLanguage(): Language {
//    return when (this) {
//        LanguagePreference.ENGLISH -> Language.ENGLISH
//        LanguagePreference.INDONESIA -> Language.INDONESIA
//    }
//}

fun List<LanguageItem>.select(language: Language): List<LanguageItem> {
    return map {
        it.copy(applied = it.language == language)
    }
}
