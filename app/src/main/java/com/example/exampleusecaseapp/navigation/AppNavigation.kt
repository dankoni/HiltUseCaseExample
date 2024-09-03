package com.example.exampleusecaseapp.navigation

enum class Screen {
    MAIN,
    PLANETS,
    SHIPS,
    PLANETINFO
}
sealed class NavigationItem(val route: String) {
    object Main : NavigationItem(Screen.MAIN.name)
    object Planets : NavigationItem(Screen.PLANETS.name)
    object Ships : NavigationItem(Screen.SHIPS.name)
    object PlanetInfo: NavigationItem(Screen.PLANETINFO.name)
}