package com.example.exampleusecaseapp.features.planets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.planets.PlanetListUseCase
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
class PlanetListViewModel @Inject constructor(
    private val planetListUseCase: PlanetListUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<PlanetListUIState>(PlanetListUIState.None)

    val state = _state.asStateFlow()

    fun getPlanets() {
        _state.value = PlanetListUIState.Loading
        viewModelScope.launch {
            planetListUseCase()
                .catch {
                    emitAll(flowOf(emptyList()))
                }.map { list ->
                    list?.map { data ->
                        PlanetModel(
                            id = data.id,
                            name = data.name,
                            orbitalPeriod = data.orbitalPeriod
                        )
                    }
                }.flowOn(Dispatchers.IO).collect { list ->
                    _state.value = PlanetListUIState.Planets(planetList = list ?: emptyList())
                }
        }
    }
}

sealed interface PlanetListUIState {
    data object None : PlanetListUIState
    data object Loading : PlanetListUIState
    data class Planets(val planetList: List<PlanetModel>) : PlanetListUIState
}
