package com.artemissoftware.narutoglossary.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.artemissoftware.narutoglossary.presentation.screens.onboarding.OnboardingScreen
import com.artemissoftware.narutoglossary.presentation.screens.splash.SplashScreen
import com.artemissoftware.narutoglossary.util.Constants.DETAILS_ARGUMENT_KEY
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Welcome.route) {
            OnboardingScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {

        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument(DETAILS_ARGUMENT_KEY) {
                    type = NavType.IntType
                }
            )
        ) {

        }
        composable(route = Screen.Search.route) {

        }
    }
}