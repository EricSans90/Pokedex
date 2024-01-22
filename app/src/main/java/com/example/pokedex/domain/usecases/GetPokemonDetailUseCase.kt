package com.example.pokedex.domain.usecases

// Interactuar con el repositorio para obtener los detalles de un Pokémon

import com.example.pokedex.domain.repositories.PokemonRepository
import javax.inject.Inject

class GetPokemonDetailUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    operator fun invoke(pokemonName: String) = pokemonRepository.getPokemonDetail(pokemonName)
}