package com.example.pokedex.domain.usecases

//Para obtener la lista de Pokémon

import android.content.Context
import com.example.pokedex.data.util.loadPokemonFromAssets
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

// Para ditto.json
class GetPokemonListUseCase @Inject constructor(
    private val context: Context,
    private val pokemonRepository: PokemonRepository
) {
    fun execute(): Flow<List<Pokemon>> = flow {
        val ditto = loadPokemonFromAssets(context)
        emit(listOf(ditto))
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