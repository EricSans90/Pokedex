package com.example.pokedex.domain.usecases

//Para obtener la lista de Pokémon

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import javax.inject.Inject

// Para obtener la lista pokemon
class GetPokemonListUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend fun execute(): List<Pokemon> {
        // Cambio al contexto IO para hacer operaciones de entrada/salida
        return withContext(Dispatchers.IO) {
            pokemonRepository.getPokemonList().first()
        }
    }
}
