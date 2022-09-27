package com.aldikitta.thingstodo.runtime.navigation

import androidx.compose.material.ModalBottomSheetDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import com.aldikitta.thingstodo.foundation.window.WindowState
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator

const val MinLargeScreenWidth = 585

@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
fun MainNavHost(windowState: WindowState){
    val bottomSheetNavigator = rememberBottomSheetNavigator()
    val bottomSheetConfig = remember {
        mutableStateOf(DefaultMainBottomSheetConfig)
    }

    val smallestScreenWidthDp = LocalConfiguration.current.smallestScreenWidthDp

    val isLargeScreen = smallestScreenWidthDp > MinLargeScreenWidth

    ModalBottomSheetLayout(
        bottomSheetNavigator = bottomSheetNavigator,
        sheetShape = bottomSheetConfig.value.sheetShape,
        scrimColor = if (bottomSheetConfig.value.showScrim){
            ModalBottomSheetDefaults.scrimColor
        }else{
            Color.Transparent
        }
    ) {
        if (isLargeScreen){

        }else{

        }
    }
}