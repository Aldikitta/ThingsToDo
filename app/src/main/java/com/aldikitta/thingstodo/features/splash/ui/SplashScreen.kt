package com.aldikitta.thingstodo.features.splash.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.aldikitta.thingstodo.foundation.viewmodel.HandleEffect
import com.aldikitta.thingstodo.runtime.navigation.AuthFlow
import com.aldikitta.thingstodo.runtime.navigation.HomeFLow
import com.aldikitta.thingstodo.runtime.navigation.MainFlow

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel
) {
    HandleEffect(viewModel){
        when (it){
            SplashEffect.NavigateToDashboard ->{
                navController.navigate(HomeFLow.Root.route){
                    popUpTo(MainFlow.Root.route){
                        inclusive = true
                    }
                }
            }
            SplashEffect.NavigateToLogin ->{
                navController.navigate(AuthFlow.Root.route){
                    popUpTo(MainFlow.Root.route){
                        inclusive = true
                    }
                }
            }
        }
    }
}