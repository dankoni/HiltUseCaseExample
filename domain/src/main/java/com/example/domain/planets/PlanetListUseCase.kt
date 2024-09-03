package com.example.domain.planets

import com.example.data.PlanetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlanetListUseCase @Inject constructor(
    private val planetRepository: PlanetRepository
) {

    operator fun invoke(): Flow<List<Planet>?> {
        return planetRepository.allPlanets().map { list ->
            list?.map { planet ->
                 Planet(
                    id = planet.id ,
                    name = planet.name ,
                    orbitalPeriod = planet.orbitalPeriod
                )
            }
        }
    }
}