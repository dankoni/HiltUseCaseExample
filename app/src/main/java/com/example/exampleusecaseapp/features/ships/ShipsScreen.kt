package com.example.exampleusecaseapp.features.ships

import android.annotation.SuppressLint
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
import androidx.compose.ui.unit.dp

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ShipsScreen(
    shipListScreenParams:ShipListScreenParams
){

    when(shipListScreenParams.viewState){
        ShipsUiState.Loading -> LoadingShips()
        ShipsUiState.None -> Unit
        is ShipsUiState.ShipNames ->
            ShipNameScreen(names = shipListScreenParams.viewState.names )
        is ShipsUiState.ShipsClass ->
            ShipClassScreen(classAndName =  shipListScreenParams.viewState.classAndName )
        is ShipsUiState.ShipsHypedrive ->
            ShipRatingScreen(ratingAndName =  shipListScreenParams.viewState.ratingAndName )
    }

}

@Composable
fun LoadingShips(){
    Column(modifier = Modifier.fillMaxSize()
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
fun ShipNameScreen(
    names:List<ShipName>
){
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 16.dp, vertical = 20.dp)) {
        names.forEach { shipName->
            item {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .clickable { }) {
                    Text(text = shipName.name)
                }
            }
        }
    }
}

@Composable
fun ShipClassScreen(
    classAndName:List<ShipClass>
){
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 16.dp, vertical = 20.dp)) {
        classAndName.forEach { shipName->
            item {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .clickable { }) {
                    Text(text = shipName.name)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = shipName.className)
                }
            }
        }
    }
}

@Composable
fun ShipRatingScreen(
    ratingAndName:List<ShipHyperdrive>
){
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 16.dp, vertical = 20.dp)) {

        ratingAndName.forEach { shipName->
            item {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .clickable { }) {
                    Text(text = shipName.name)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = shipName.rating.toString())
                }
            }
        }
    }
}