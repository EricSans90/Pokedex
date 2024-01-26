package com.example.pokedex.ui.viewmodels

//Para manejar el estado de la lista de Pokémon

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.usecases.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// Para ditto.json
@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {

    val pokemonList: LiveData<List<Pokemon>> = liveData {
        emit(getPokemonListUseCase.execute())
    }
}