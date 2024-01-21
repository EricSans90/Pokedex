package com.example.pokedex.data.repositories

//Implementación del repositorio de Pokémon

import com.example.pokedex.data.mappers.PokemonDataMapper
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.PokemonRepository
import com.example.pokedex.data.sources.remote.PokemonRemoteDataSource
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow


class PokemonRepositoryImpl(
    private val remoteDataSource: PokemonRemoteDataSource,
    private val dataMapper: PokemonDataMapper
) : PokemonRepository {
    override fun getPokemonList(): Flow<List<Pokemon>> {
        TODO("Falta implementar")
    }

    override fun getPokemonDetail(pokemonName: String): Flow<Pokemon> = flow {
        val dto = remoteDataSource.getPokemonDetail(pokemonName)
        val domainModel = dataMapper.mapPokemonDTOToPokemon(dto)
        emit(domainModel)
    }
}