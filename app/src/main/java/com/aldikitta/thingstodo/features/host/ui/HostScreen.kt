package com.aldikitta.thingstodo.features.host.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aldikitta.thingstodo.ui.theme.ThingstodoTheme

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun HostScreen(content: @Composable () -> Unit) {
    val viewModel = hiltViewModel<HostViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

//    ThingstodoTheme(theme = state.theme, content = content)
    Surface() {
        Box(modifier = Modifier.fillMaxSize()){
            Text(text = "hello", textAlign = TextAlign.Center)
        }
    }
}