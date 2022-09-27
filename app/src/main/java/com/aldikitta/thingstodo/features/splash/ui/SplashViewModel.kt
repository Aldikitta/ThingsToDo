package com.aldikitta.thingstodo.features.splash.ui

import androidx.lifecycle.viewModelScope
import com.aldikitta.thingstodo.features.splash.repository.SplashEnvironmentRepository
import com.aldikitta.thingstodo.foundation.viewmodel.StatefulViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    splashEnvironmentRepository: SplashEnvironmentRepository
) : StatefulViewModel<Unit, SplashEffect, SplashAction, SplashEnvironmentRepository>(Unit, splashEnvironmentRepository){
    init{
        dispatch(SplashAction.AppLaunch)
    }
    override fun dispatch(action: SplashAction) {
        when (action){
            is SplashAction.AppLaunch ->{
                viewModelScope.launch {
                    environment.getCredential()
                        .collect{
                            // if (it.isLoggedIn()) {
                            setEffect(SplashEffect.NavigateToDashboard)
//                            } else {
//                                setEffect(SplashEffect.NavigateToLogin)
//                            }
                        }
                }
            }
        }
    }
}