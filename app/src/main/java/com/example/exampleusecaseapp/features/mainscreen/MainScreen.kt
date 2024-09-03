package com.example.exampleusecaseapp.features.mainscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.exampleusecaseapp.navigation.NavigationItem

@Composable
fun MainScreen(
    navHostController: NavHostController,
){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Button(onClick = { navHostController.navigate(NavigationItem.Planets.route) }) {
            Text(text = "Planets")
        }
        Spacer(modifier = Modifier.height(25.dp))
        Button(onClick = { navHostController.navigate(NavigationItem.Ships.route) }) {
            Text(text = "Ships")
        }
    }
}