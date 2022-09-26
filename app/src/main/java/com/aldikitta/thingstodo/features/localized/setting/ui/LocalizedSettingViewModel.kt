package com.aldikitta.thingstodo.features.localized.setting.ui

import androidx.lifecycle.viewModelScope
import com.aldikitta.thingstodo.R
import com.aldikitta.thingstodo.features.localized.setting.data.ILocalizedSettingEnvironment
import com.aldikitta.thingstodo.foundation.extension.select
import com.aldikitta.thingstodo.foundation.viewmodel.StatefulViewModel
import com.aldikitta.thingstodo.model.Language
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
//class LocalizedSettingViewModel @Inject constructor(localizedSettingEnvironment: ILocalizedSettingEnvironment) :
//    StatefulViewModel<LocalizedSettingState, LocalizedEffect, LocalizedSettingAction, ILocalizedSettingEnvironment>(
//        LocalizedSettingState(), localizedSettingEnvironment) {
//
//    init {
//        initLanguage()
//    }
//
//    override fun dispatch(action: LocalizedSettingAction) {
//        when (action) {
//            is LocalizedSettingAction.SelectLanguage -> {
//                viewModelScope.launch {
//                    environment.setLanguage(action.selected.language)
//                    setEffect(LocalizedEffect.ApplyLanguage(action.selected.language))
//                }
//            }
//        }
//    }
//
//    private fun initLanguage() {
//        viewModelScope.launch {
//            delay(100)
//            environment.getLanguage()
//                .collect {
//                    setState { copy(items = initial().select(it)) }
//                }
//        }
//    }
//
//    private fun initial() = listOf(
//        LanguageItem(
//            title = R.string.setting_language_english,
//            language = Language.ENGLISH,
//            applied = false
//        ),
//        LanguageItem(
//            title = R.string.setting_language_indonesia,
//            language = Language.INDONESIA,
//            applied = false
//        ),
//    )
//}
