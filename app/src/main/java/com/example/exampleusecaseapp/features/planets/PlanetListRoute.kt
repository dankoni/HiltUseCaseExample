package com.example.exampleusecaseapp.features.planets

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.exampleusecaseapp.navigation.NavigationItem

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun PlanetListRoute(
    navHostController: NavHostController,
    viewModel: PlanetListViewModel = hiltViewModel()
) {
    val viewState = viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.getPlanets()
    }

    PlanetListScreen(
        PlanetListScreenParams(
            viewState =viewState.value,
            onPlanetClicked ={ planetId->
                navHostController.navigate("${NavigationItem.PlanetInfo.route}/$planetId")
            }
        )
    )
}

