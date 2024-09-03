package com.example.exampleusecaseapp.features.planets

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class PlanetListPreviewProvider : PreviewParameterProvider<PlanetListScreenParams> {
    override val values: Sequence<PlanetListScreenParams>
        get() = sequenceOf(
            PlanetListScreenParams(
                viewState = PlanetListUIState.None,
                onPlanetClicked = {}
            ),
            PlanetListScreenParams(
                viewState = PlanetListUIState.Planets(
                    listOf(
                        PlanetModel(
                            id ="#3434343",
                            name ="Corusant",
                            orbitalPeriod = 345
                        )
                    )
                ),
                onPlanetClicked = {}
            )


        )
}