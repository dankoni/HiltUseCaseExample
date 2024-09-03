package com.example.exampleusecaseapp.features.planets

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController

@Composable
fun PlanetInfoRoute(
    navHostController: NavHostController,
    planetId:String,
    viewModel: PlanetInfoViewModel = hiltViewModel()
){
    val state =  viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        Log.d("LOADINGPLANET","ID of planet: $planetId")
        viewModel.planetInfo(planetId)
    }

    when(state.value){
        PlanetInfoState.Loading -> LoadingPlanet()
        PlanetInfoState.NoPlanet -> NoPlanet()
        PlanetInfoState.None -> Unit
        is PlanetInfoState.PlanetInformation ->
            PlanetInfo((state.value as PlanetInfoState.PlanetInformation).planet)
    }
}