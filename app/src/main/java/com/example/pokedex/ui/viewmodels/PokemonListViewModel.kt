package com.example.pokedex.ui.viewmodels

//Para manejar el estado de la lista de Pokémon

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.pokedex.domain.usecases.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// Para ditto.json
@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {

    val pokemonList = getPokemonListUseCase.execute().asLiveData()
}

/* Para API
@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {
    // Lógica para obtener la lista de pokémon y ponerla en la UI
    val pokemonList = getPokemonListUseCase.execute().asLiveData(viewModelScope.coroutineContext)
}
 */