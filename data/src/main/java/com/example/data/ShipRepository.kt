package com.example.data

import com.example.data.model.ShipData
import com.example.network.ShipsAccessor
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ShipRepository @Inject constructor(
    private val shipsAccessor: ShipsAccessor
) {

    fun allShips() = shipsAccessor.getAllShips().map { list->
        list?.map {  ship->
            ShipData(
                id = ship?.id?:"",
                name = ship?.name?:"",
                model = ship?.model?:"",
                crew = ship?.crew?:"",
                starshipClass = ship?.starshipClass?:"",
                hyperDriveRating = ship?.hyperdriveRating?:0.0
            )
        }
    }
}