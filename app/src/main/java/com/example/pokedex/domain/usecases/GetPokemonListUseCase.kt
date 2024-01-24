package com.example.pokedex.domain.usecases

//Para obtener la lista de Pokémon

import android.content.Context
import com.example.pokedex.data.util.loadPokemonFromAssets
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
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


// Para API
/*
class GetPokemonListUseCase(private val pokemonRepository: PokemonRepository) {
    //lógica para obtener la lista de Pokémon desde el repositorio
    fun execute(): Flow<List<Pokemon>> {
        return pokemonRepository.getPokemonList()
    }
}
 */