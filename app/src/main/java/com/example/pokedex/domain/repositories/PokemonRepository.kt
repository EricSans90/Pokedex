package com.example.pokedex.domain.repositories

//Para abstraer las fuentes de datos y proveer datos al dominio

import com.example.pokedex.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    // Para obtener la lista de Pokemon (Puede retornar un Flow o cualquier tipo de stream de datos)
    fun getPokemonList(): Flow<List<Pokemon>>

    // Para obtener los detalles de un pokemon específico
    fun getPokemonDetail(pokemonId: String): Flow<Pokemon>
}