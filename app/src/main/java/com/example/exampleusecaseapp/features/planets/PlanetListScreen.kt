package com.example.exampleusecaseapp.features.planets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun PlanetListScreen(
    @PreviewParameter(PlanetListPreviewProvider::class)
    planetListScreenParams: PlanetListScreenParams
) {
    when (planetListScreenParams.viewState) {
        PlanetListUIState.None -> Unit
        is PlanetListUIState.Planets -> {
            PlanetList(
                planetListScreenParams.viewState.planetList,
                onPlanetCLicked = { planetId ->
                    planetListScreenParams.onPlanetClicked(planetId)
                }
            )
        }

        PlanetListUIState.Loading -> LoadingPlanet()
    }
}

@Composable
fun LoadingPlanet() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    }
}

@Composable
fun PlanetList(
    planetList: List<PlanetModel>,
    onPlanetCLicked: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        planetList.forEach { planet ->
            item {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onPlanetCLicked(planet.id) }
                ) {
                    Text(text = planet.name)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = planet.orbitalPeriod.toString())
                }
            }
        }
    }
}


