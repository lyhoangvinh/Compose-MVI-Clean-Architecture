package com.base.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.base.app.ui.home.HomeScreen
import com.base.app.ui.detail.DetailScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = AppRoute.Home.route
    ) {
        composable(AppRoute.Home.route) {
            HomeScreen(
                onNavigateToDetail = { id ->
                    navController.navigate(AppRoute.Detail.createRoute(id))
                }
            )
        }
        composable(
            route = AppRoute.Detail.route,
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailScreen(
                id = backStackEntry.arguments?.getString("id").orEmpty(),
                onBack = { navController.popBackStack() }
            )
        }
    }
}
