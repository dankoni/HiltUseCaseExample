package com.example.exampleusecaseapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.exampleusecaseapp.features.mainscreen.MainScreen
import com.example.exampleusecaseapp.features.planets.PlanetInfoRoute
import com.example.exampleusecaseapp.features.planets.PlanetListRoute
import com.example.exampleusecaseapp.features.ships.ShipListRoute

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Main.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = NavigationItem.Main.route) {
            MainScreen(navController)
        }
        composable(route = NavigationItem.Planets.route) {
            PlanetListRoute(navController)
        }
        composable(route = NavigationItem.Ships.route) {
            ShipListRoute(navController)
        }
        composable(
            route = "${NavigationItem.PlanetInfo.route}/{planetId}",
            arguments = listOf(navArgument("planetId") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val planetId = backStackEntry.arguments?.getString("planetId")
            planetId?.let {
                PlanetInfoRoute(
                    navController,
                    planetId
                )
            }
        }
    }
}