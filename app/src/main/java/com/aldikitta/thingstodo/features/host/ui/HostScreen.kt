package com.aldikitta.thingstodo.features.host.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aldikitta.thingstodo.ui.theme.ThingstodoTheme

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun HostScreen(content: @Composable () -> Unit) {
    val viewModel = hiltViewModel<HostViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    ThingstodoTheme(theme = state.theme, content = content)
}