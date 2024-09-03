package com.example.network

import com.example.network.models.AllShipsQuery
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ShipsAccessor @Inject constructor(
    private val starWarsClient: StarWarsClient
) {

    fun getAllShips() = starWarsClient.buildApolloClient().query(
        AllShipsQuery()
    ).toFlow()
        .map { response ->
            if (response.hasErrors()){
                error(
                    NetworkError(errorMsg = "Ships endpoint fails")
                )
            }
            response.data?.allStarships?.starships
        }

    fun shipInfo(shipId:String) = starWarsClient.buildApolloClient()
}