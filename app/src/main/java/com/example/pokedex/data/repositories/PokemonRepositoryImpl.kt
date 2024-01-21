package com.example.pokedex.data.repositories

//Implementación del repositorio de Pokémon

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.PokemonRepository
import com.example.pokedex.data.sources.remote.PokemonRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokemonRepositoryImpl(
    private val pokemonRemoteDataSource: PokemonRemoteDataSource
) : PokemonRepository {

    override fun getPokemonList(): Flow<List<Pokemon>> = flow {
        //llamar a la fuente de datos remota y convertir la respuesta a una lista de modelos de dominio
        val pokemonList = pokemonRemoteDataSource.getPokemonList()
        emit(pokemonList)
    }

    override fun getPokemonDetail(pokemonId: Int): Flow<Pokemon> = flow {
        //llamar a la fuente de datos remota y convertir la respuesta a los detalles de 1 Pokemon específico
        val pokemonDetail = pokemonRemoteDataSource.getPokemonDetail(pokemonId)
        emit(pokemonDetail)
    }
}