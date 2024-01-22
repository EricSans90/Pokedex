package com.example.pokedex.domain.usecases

// Interactuar con el repositorio para obtener los detalles de un Pokémon

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonDetailUseCase(private val pokemonRepository: PokemonRepository) {
    fun execute(pokemonId: String): Flow<Pokemon> {
        // Lógica para obtener los detalles de un Pokémon específico
        // Por ahora, simplemente devolveremos Ditto desde el repositorio
        return pokemonRepository.getPokemonDetail(pokemonId)
    }
}