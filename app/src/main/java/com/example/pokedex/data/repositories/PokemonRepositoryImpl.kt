package com.example.pokedex.data.repositories

//Implementación del repositorio de Pokémon

import com.example.pokedex.data.mappers.PokemonDataMapper
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.PokemonRepository
import com.example.pokedex.data.sources.remote.PokemonRemoteDataSource
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class PokemonRepositoryImpl @Inject constructor(
    private val remoteDataSource: PokemonRemoteDataSource,
    private val dataMapper: PokemonDataMapper
) : PokemonRepository {
    override fun getPokemonList(): Flow<List<Pokemon>> = flow {
        val pokemonDtoList = remoteDataSource.getPokemonList()
        // Filtrar los nulos después de mapear
        val pokemonList = pokemonDtoList.mapNotNull(dataMapper::mapPokemonDTOToPokemon)
        emit(pokemonList)
    }

    override fun getPokemonDetail(pokemonName: String): Flow<Pokemon> = flow {
        val dto = remoteDataSource.getPokemonDetail(pokemonName)
        val domainModel = dataMapper.mapPokemonDTOToPokemon(dto)
        // Manejar el caso en que domainModel sea null
        domainModel?.let { emit(it) } ?: throw Exception("Pokemon no encontrado")
    }
}