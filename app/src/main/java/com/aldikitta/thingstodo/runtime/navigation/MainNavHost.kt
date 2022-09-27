package com.aldikitta.thingstodo.runtime.navigation

import androidx.compose.material.ModalBottomSheetDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aldikitta.thingstodo.features.splash.ui.SplashViewModel
import com.aldikitta.thingstodo.foundation.window.WindowState
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator

const val MinLargeScreenWidth = 585

@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
fun MainNavHost(windowState: WindowState) {
    val bottomSheetNavigator = rememberBottomSheetNavigator()
    val bottomSheetConfig = remember {
        mutableStateOf(DefaultMainBottomSheetConfig)
    }

    val smallestScreenWidthDp = LocalConfiguration.current.smallestScreenWidthDp

    val isLargeScreen = smallestScreenWidthDp > MinLargeScreenWidth

    ModalBottomSheetLayout(
        bottomSheetNavigator = bottomSheetNavigator,
        sheetShape = bottomSheetConfig.value.sheetShape,
        scrimColor = if (bottomSheetConfig.value.showScrim) {
            ModalBottomSheetDefaults.scrimColor
        } else {
            Color.Transparent
        }
    ) {
        if (isLargeScreen) {

        } else {

        }
    }
}

@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
private fun LargeScreenNavHost(
    bottomSheetNavigator: BottomSheetNavigator,
    windowState: WindowState,
    bottomSheetConfig: MainBottomSheetConfig
) {
    val navController = rememberNavController(bottomSheetNavigator)

    NavHost(
        navController = navController,
        startDestination = MainFlow.Root.route
    ) {
        composable(route = MainFlow.Root.route){
            val viewModel = hiltViewModel<SplashViewModel>()

        }
    }
}