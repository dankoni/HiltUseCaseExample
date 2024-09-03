package com.example.exampleusecaseapp.features.planets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController

@Composable
fun NoPlanet(){
    Column(modifier = Modifier.fillMaxSize()
        .padding(horizontal = 16.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Unknown planet")
        Spacer(modifier = Modifier.width(10.dp))
    }
}

@Composable
fun PlanetInfo(planetModel: PlanetInfoModel){
    Column(modifier = Modifier.fillMaxSize()
        .padding(horizontal = 16.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        Text(text = planetModel.name)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = planetModel.orbitalPeriod.toString())
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = planetModel.population)
        Spacer(modifier = Modifier.width(10.dp))
    }
}