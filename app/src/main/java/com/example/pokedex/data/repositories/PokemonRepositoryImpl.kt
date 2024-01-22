package com.example.pokedex.data.repositories

//Implementación del repositorio de Pokémon

import android.content.Context
import com.example.pokedex.data.mappers.PokemonDataMapper
import com.example.pokedex.data.models.PokemonDTO
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.PokemonRepository
import com.example.pokedex.data.sources.remote.PokemonRemoteDataSource
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import java.io.InputStreamReader
import javax.inject.Inject

// Para ditto.json estático
class PokemonRepositoryImpl @Inject constructor(
    private val context: Context,
    private val dataMapper: PokemonDataMapper
) : PokemonRepository {

    // Asumiendo que ditto.json está en la carpeta assets
    private fun getDittoJson(): String {
        val inputStream = javaClass.classLoader?.getResourceAsStream("assets/ditto.json")
        val reader = InputStreamReader(inputStream)
        return reader.readText()
    }

    override fun getPokemonList(): Flow<List<Pokemon>> = flow {
        val dittoJson = getDittoJson()
        val dto = Gson().fromJson(dittoJson, PokemonDTO::class.java)
        val pokemon = dataMapper.mapPokemonDTOToPokemon(dto)
        emit(listOfNotNull(pokemon))
    }

    override fun getPokemonDetail(pokemonId: String): Flow<Pokemon> = flow {
        val dittoJson = getDittoJson()
        val dto = Gson().fromJson(dittoJson, PokemonDTO::class.java)
        val pokemon = dataMapper.mapPokemonDTOToPokemon(dto)
        emit(pokemon ?: throw Exception("Pokemon no encontrado"))
    }
}

/* PARA API

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
*/