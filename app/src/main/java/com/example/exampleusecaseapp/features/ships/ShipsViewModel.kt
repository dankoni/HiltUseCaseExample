package com.example.exampleusecaseapp.features.ships

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.ships.ShipClassAndNameUseCase
import com.example.domain.ships.ShipNameAndHypedriveUseCase
import com.example.domain.ships.ShipNamesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShipsViewModel @Inject constructor(
    private val shipNamesUseCase: ShipNamesUseCase,
    private val shipClassAndNameUseCase: ShipClassAndNameUseCase,
    private val shipNameAndHypedriveUseCase: ShipNameAndHypedriveUseCase
) :ViewModel() {

    private val _state = MutableStateFlow<ShipsUiState>(ShipsUiState.None)

    val state = _state.asStateFlow()

    fun shipNames(){
        _state.value = ShipsUiState.Loading
        viewModelScope.launch {
            shipNamesUseCase().catch {
                emitAll(flowOf(emptyList()))
            }.map { list ->
                list?.map { data ->
                    ShipName(
                        name = data
                    )
                }
            }.flowOn(Dispatchers.IO)
                .collect { list ->
                    _state.value = ShipsUiState.ShipNames(names = list?: emptyList())
                }
        }
    }

    fun shipByClass(){
        _state.value = ShipsUiState.Loading
        viewModelScope.launch {
            shipClassAndNameUseCase().catch {
                emitAll(flowOf(emptyList()))
            }.map { list ->
                list?.map { data ->
                    ShipClass(
                        id = data.id,
                        name = data.name,
                        className = data.className
                    )
                }
            }.flowOn(Dispatchers.IO)
                .collect { list ->
                    _state.value = ShipsUiState.ShipsClass(classAndName = list?: emptyList())
                }
        }
    }

    fun shipByHyperdirve(){
        _state.value = ShipsUiState.Loading
        viewModelScope.launch {
            shipNameAndHypedriveUseCase().catch {
                emitAll(flowOf(emptyList()))
            }.map { list ->
                list?.map { data ->
                    ShipHyperdrive(
                        id = data.id,
                        name = data.name,
                        rating = data.hyperdriveRating
                    )
                }
            }.flowOn(Dispatchers.IO)
                .collect { list ->
                    _state.value = ShipsUiState.ShipsHypedrive(ratingAndName = list?: emptyList())
                }
        }
    }


}

sealed interface ShipsUiState{
    data object None : ShipsUiState
    data object Loading :ShipsUiState
    data class ShipNames(val  names:List<ShipName>): ShipsUiState
    data class ShipsClass(val classAndName:List<ShipClass>):ShipsUiState
    data class ShipsHypedrive(val ratingAndName:List<ShipHyperdrive>):ShipsUiState
}