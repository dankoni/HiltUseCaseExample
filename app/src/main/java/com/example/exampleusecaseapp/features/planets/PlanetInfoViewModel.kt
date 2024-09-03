package com.example.exampleusecaseapp.features.planets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.planets.PlanetInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanetInfoViewModel @Inject constructor(
    private val planetInfoUseCase: PlanetInfoUseCase
): ViewModel() {

    private val _state= MutableStateFlow<PlanetInfoState>(PlanetInfoState.None)

    val state = _state.asStateFlow()

    fun planetInfo(planetId:String){
        _state.value = PlanetInfoState.Loading
        viewModelScope.launch {
            planetInfoUseCase(planetId).catch {e->
                 e.printStackTrace()
                _state.value = PlanetInfoState.NoPlanet
            }.map{ planet->
                PlanetInfoModel(
                    id =planet.id,
                    name = planet.name,
                    orbitalPeriod = planet.orbitalPeriod,
                    population = planet.population
                )
            }.flowOn(Dispatchers.IO)
                .collect{ info->
                    _state.value = PlanetInfoState.PlanetInformation(info)
                }
        }
    }
}

sealed interface PlanetInfoState{
    data object None: PlanetInfoState
    data object Loading: PlanetInfoState
    data object NoPlanet:PlanetInfoState
    data class PlanetInformation(val planet:PlanetInfoModel):PlanetInfoState

}