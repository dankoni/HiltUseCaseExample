package com.example.domain.ships

import com.example.data.ShipRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ShipNameAndHypedriveUseCase @Inject constructor(
    private val shipRepository: ShipRepository
) {

    operator fun invoke(): Flow<List<ShipHyperdrive>?> {
        return shipRepository.allShips().map { list ->
            list?.map { ship ->
                ShipHyperdrive(
                    id = ship.id,
                    name = ship.name,
                    hyperdriveRating = ship.hyperDriveRating
                )
            }
        }
    }
}