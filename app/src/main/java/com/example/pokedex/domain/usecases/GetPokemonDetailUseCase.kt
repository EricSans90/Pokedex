package com.example.pokedex.domain.usecases

// Interactuar con el repositorio para obtener los detalles de un Pokémon

import com.example.pokedex.domain.repositories.PokemonRepository

class GetPokemonDetailUseCase(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(pokemonName: String) = pokemonRepository.getPokemonDetail(pokemonName)
}