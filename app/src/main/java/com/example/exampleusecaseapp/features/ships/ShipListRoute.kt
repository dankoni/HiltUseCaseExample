package com.example.exampleusecaseapp.features.ships

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ShipListRoute (
    navHostController: NavHostController,
    viewModel: ShipsViewModel = hiltViewModel()
) {
    val viewState = viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.shipNames()
    }

    ShipsScreen(shipListScreenParams =
        ShipListScreenParams(
            viewState = viewState.value,
            onShiptClicked ={}

        )
    )
}