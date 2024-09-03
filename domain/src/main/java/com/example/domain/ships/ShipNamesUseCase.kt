package com.example.domain.ships

import com.example.data.ShipRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ShipNamesUseCase @Inject constructor(
    private val shipRepository: ShipRepository
) {

    operator fun invoke(): Flow<List<String>?> {
        return shipRepository.allShips().map { list ->
            list?.map { ship ->
                ship.name
            }
        }
    }
}