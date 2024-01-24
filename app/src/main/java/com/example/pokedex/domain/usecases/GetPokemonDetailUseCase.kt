package com.example.pokedex.domain.usecases

// Interactuar con el repositorio para obtener los detalles de un Pokémon

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

// Interactuar con el repositorio para obtener los detalles de un Pokémon
class GetPokemonDetailUseCase(private val pokemonRepository: PokemonRepository) {
    suspend fun execute(pokemonId: String): Pokemon {
        // Lógica para obtener los detalles de un Pokémon específico
        // Por ahora, devuelvo Ditto desde el repositorio
        // first() devuelve el primer valor emitido por el flow
        return withContext(Dispatchers.IO) {
            pokemonRepository.getPokemonDetail(pokemonId).first()
        }
    }
}