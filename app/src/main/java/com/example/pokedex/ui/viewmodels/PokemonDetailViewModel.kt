package com.example.pokedex.ui.viewmodels

//Para manejar el estado de los detalles de un Pokémon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.*
import androidx.lifecycle.viewModelScope
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.usecases.GetPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import androidx.lifecycle.asLiveData
import javax.inject.Inject

// Para ditto
@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase
) : ViewModel() {

    fun getPokemonDetail(pokemonId: String): LiveData<Pokemon> = liveData {
        emit(getPokemonDetailUseCase.execute(pokemonId))
    }
}