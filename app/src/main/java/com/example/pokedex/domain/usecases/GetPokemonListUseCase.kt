package com.example.pokedex.domain.usecases

//Para obtener la lista de Pokémon

import com.example.pokedex.domain.repositories.PokemonRepository

class GetPokemonListUseCase(private val pokemonRepository: PokemonRepository) {
    //lógica para obtener la lista de Pokémon desde el repositorio
}