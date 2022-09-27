package com.aldikitta.thingstodo.features.host.ui

import androidx.lifecycle.viewModelScope
import com.aldikitta.thingstodo.features.host.repository.HostEnvironmentRepository
import com.aldikitta.thingstodo.foundation.viewmodel.StatefulViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HostViewModel @Inject constructor(hostEnvironment: HostEnvironmentRepository) :
    StatefulViewModel<HostState, Unit, Unit, HostEnvironmentRepository>(HostState(), hostEnvironment) {

    init {
        initTheme()
    }

    override fun dispatch(action: Unit) {

    }

    private fun initTheme() {
        viewModelScope.launch {
            environment.getTheme()
                .collect { setState { copy(theme = it) } }
        }
    }

}