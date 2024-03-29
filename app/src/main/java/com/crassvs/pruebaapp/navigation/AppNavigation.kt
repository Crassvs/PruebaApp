package com.crassvs.pruebaapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.crassvs.pruebaapp.screens.SplashScreenView
import com.crassvs.pruebaapp.screens.home.HomeScreen
import com.crassvs.pruebaapp.screens.login.LoginScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreen.name
    ){
        composable(AppScreens.SplashScreen.name){
            SplashScreenView(navController = navController)
        }
        composable(AppScreens.LoginScreen.name){
            LoginScreen(navController = navController)
        }
        composable(AppScreens.HomeScreen.name){
            HomeScreen(navController = navController)
        }
    }
}
