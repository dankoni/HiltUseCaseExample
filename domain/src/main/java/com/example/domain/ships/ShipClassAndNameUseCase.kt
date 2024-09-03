package com.example.domain.ships

import com.example.data.ShipRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ShipClassAndNameUseCase @Inject constructor(
    private val shipRepository: ShipRepository
) {
    operator fun invoke(): Flow<List<ShipClass>?> {
        return shipRepository.allShips().map { list ->
            list?.map { ship ->
                ShipClass(
                    id = ship.id,
                    name = ship.name,
                    className = ship.starshipClass
                )
            }
        }
    }
}