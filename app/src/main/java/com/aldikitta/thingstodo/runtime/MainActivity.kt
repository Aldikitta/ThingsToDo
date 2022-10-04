package com.aldikitta.thingstodo.runtime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.aldikitta.thingstodo.R
import com.aldikitta.thingstodo.features.host.ui.HostScreen
import com.aldikitta.thingstodo.foundation.window.WindowState
import com.aldikitta.thingstodo.foundation.window.rememberWindowState
import com.aldikitta.thingstodo.runtime.navigation.MainNavHost
import com.aldikitta.thingstodo.ui.theme.ThingstodoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var windowState: WindowState
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            windowState = rememberWindowState()
            HostScreen {
                Surface {
//                    Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background))
                    MainNavHost(windowState)
                }
            }
        }
    }
}