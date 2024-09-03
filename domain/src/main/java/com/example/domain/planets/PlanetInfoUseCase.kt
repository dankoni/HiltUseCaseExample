package com.example.domain.planets

import com.example.data.PlanetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlanetInfoUseCase @Inject constructor(
    private val planetRepository: PlanetRepository
) {

    operator fun invoke(planetId:String): Flow<PlanetInfo> {
      return  planetRepository.planetInfo(planetId = planetId).map { planet->
          PlanetInfo(
                id = planet.id,
                name = planet.name,
                orbitalPeriod = planet.orbitalPeriod,
                population = planet.population
            )
        }
    }
}