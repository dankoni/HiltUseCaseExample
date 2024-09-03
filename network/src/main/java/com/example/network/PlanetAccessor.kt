package com.example.network

import android.util.Log
import com.apollographql.apollo.api.ApolloResponse
import com.example.network.models.AllPlanetsQuery
import com.example.network.models.PlanetInfoQuery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlanetAccessor @Inject constructor(
    private val starWarsClient: StarWarsClient
) {
    fun getAllPlanets() = starWarsClient.buildApolloClient().query(
            AllPlanetsQuery()
        ).toFlow()
            .map { response ->
                if (response.hasErrors()){
                    error(
                        NetworkError(errorMsg = "Planet endpoint fails")
                    )
                }
                response.data?.allPlanets?.planets
            }

    fun planetInfo(planetId:String) = starWarsClient.buildApolloClient().query(
        PlanetInfoQuery(planetId = planetId  )
    ).toFlow()
        .map { response->
            if (response.hasErrors()){
                error(
                    NetworkError(errorMsg = "Planet endpoint fails")
                )
            }
            response.data?.planet
        }
    }


