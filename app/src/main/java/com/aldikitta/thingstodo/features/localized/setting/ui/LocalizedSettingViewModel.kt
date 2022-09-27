package com.aldikitta.thingstodo.features.localized.setting.ui

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
