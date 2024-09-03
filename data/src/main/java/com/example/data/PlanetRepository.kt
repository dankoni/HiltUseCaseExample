package com.example.data

import com.example.data.model.PlanetDataForInfo
import com.example.data.model.PlanetDataForList
import com.example.network.PlanetAccessor
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlanetRepository @Inject constructor(
    private val planetAccessor: PlanetAccessor
) {

     fun allPlanets() = planetAccessor.getAllPlanets().map { list->
         list?.map {  planet->
             PlanetDataForList(
                 id =planet?.id?:"",
                 name = planet?.name ?:"",
                 orbitalPeriod = planet?.orbitalPeriod?:0
             )
         }
     }

    fun planetInfo(planetId:String) = planetAccessor.planetInfo(planetId).map { planet->
        PlanetDataForInfo(
            id = planet?.id?:"",
            name = planet?.name?:"",
            orbitalPeriod = planet?.orbitalPeriod?:0,
            population = planet?.population.toString()
        )
    }
}

