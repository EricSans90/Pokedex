package com.example.pokedex.domain.usecases

//Para obtener la lista de Pokémon

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.PokemonRepository
import kotlinx.coroutines.flow.Flow

class GetPokemonListUseCase(private val pokemonRepository: PokemonRepository) {
    //lógica para obtener la lista de Pokémon desde el repositorio
    fun execute(): Flow<List<Pokemon>> {
        return pokemonRepository.getPokemonList()
    }
}