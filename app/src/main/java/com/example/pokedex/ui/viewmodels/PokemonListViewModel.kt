package com.example.pokedex.ui.viewmodels

//Para manejar el estado de la lista de Pokémon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokedex.domain.usecases.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {
    // Lógica para obtener la lista de pokémon y ponerla en la UI
    val pokemonList = getPokemonListUseCase.execute().asLiveData(viewModelScope.coroutineContext)
}