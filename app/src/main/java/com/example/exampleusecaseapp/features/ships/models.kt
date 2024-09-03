package com.example.exampleusecaseapp.features.ships



data class ShipListScreenParams(
    val viewState: ShipsUiState,
    val onShiptClicked: () -> Unit
)

data class ShipName(val name:String)

data class ShipClass(val id:String, val name: String,val className:String)

data class ShipHyperdrive(val id:String, val name: String,val rating:Double)
