package com.example.pokedex.ui.viewmodels

//Para manejar el estado de los detalles de un Pokémon

import androidx.lifecycle.ViewModel
import com.example.pokedex.domain.usecases.GetPokemonDetailUseCase

class PokemonDetailViewModel(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase
) : ViewModel(){
    // Lógica para obtener los detalles de pokémon y ponerla en la UI
}