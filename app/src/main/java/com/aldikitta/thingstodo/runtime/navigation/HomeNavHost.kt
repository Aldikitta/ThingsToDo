package com.aldikitta.thingstodo.runtime.navigation

import androidx.compose.runtime.MutableState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.HomeNavHost(
    navController: NavHostController,
    bottomSheetConfig: MutableState<MainBottomSheetConfig>
){
    navigation(startDestination = HomeFLow.DashboardScreen.route, route = HomeFLow.Root.route){
        composable(HomeFLow.DashboardScreen.route){
//            val viewModel = hiltViewModel<>()
        }
    }
}

fun NavGraphBuilder.HomeTabletNavHost(
    navController: NavHostController,
    navControllerLeft: NavHostController,
    navControllerRight: NavHostController,
    bottomSheetConfig: MutableState<MainBottomSheetConfig>
){

}