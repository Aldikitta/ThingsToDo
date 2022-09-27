package com.aldikitta.thingstodo.features.splash.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.aldikitta.thingstodo.foundation.viewmodel.HandleEffect

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel
) {
    HandleEffect(viewModel){
        when (it){
            SplashEffect.NavigateToDashboard ->{
                navController.navigate()
            }
        }
    }
}