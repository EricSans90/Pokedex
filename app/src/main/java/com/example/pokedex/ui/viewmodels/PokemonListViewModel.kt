package com.example.pokedex.ui.viewmodels

//Para manejar el estado de la lista de Pokémon

import androidx.lifecycle.ViewModel
import com.example.pokedex.domain.usecases.GetPokemonListUseCase

class PokemonListViewModel (
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {
    // Lógica para obtener la lista de pokémon y ponerla en la UI
}