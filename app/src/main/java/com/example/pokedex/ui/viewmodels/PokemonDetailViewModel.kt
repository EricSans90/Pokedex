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
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    getPokemonDetailUseCase: GetPokemonDetailUseCase
) : ViewModel() {
    private val _pokemonDetails = MutableStateFlow<Pokemon?>(null)
    val pokemonDetails = _pokemonDetails.asLiveData()

    init {
        viewModelScope.launch {
            _pokemonDetails.value = getPokemonDetailUseCase("ditto").firstOrNull()
        }
    }
}