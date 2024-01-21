package com.example.pokedex.domain.usecases

//Para obtener los detalles de un Pokémon

import com.example.pokedex.domain.repositories.PokemonRepository

class GetPokemonDetailUseCase(private val pokemonRepository: PokemonRepository) {
    //lógica para obtener los detalles de un Pokémon desde el repositorio
}