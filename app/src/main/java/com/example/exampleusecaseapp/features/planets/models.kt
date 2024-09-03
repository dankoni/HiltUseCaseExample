package com.example.exampleusecaseapp.features.planets


data class PlanetListScreenParams(
    val viewState: PlanetListUIState,
    val onPlanetClicked: (String) -> Unit
)

data class PlanetModel(
    val id:String,
    val name:String,
    val orbitalPeriod:Int
)

data class PlanetInfoModel(
    val id:String,
    val name:String,
    val orbitalPeriod:Int,
    val population:String
)