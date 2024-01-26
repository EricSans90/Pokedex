package com.example.pokedex.ui.viewmodels

//Para manejar el estado de los detalles de un Pokémon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.*
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.usecases.GetPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
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