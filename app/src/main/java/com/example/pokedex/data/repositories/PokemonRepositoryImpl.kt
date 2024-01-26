package com.example.pokedex.data.repositories

//Implementación del repositorio de Pokémon

import android.content.Context
import com.example.pokedex.data.mappers.PokemonDataMapper
import com.example.pokedex.data.models.PokemonDTO
import com.example.pokedex.data.sources.local.PokemonLocalDataSource
import com.example.pokedex.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.PokemonRepository
import com.google.gson.Gson
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import java.io.InputStreamReader
import javax.inject.Inject

// Para ditto.json estático
class PokemonRepositoryImpl @Inject constructor(
    private val context: Context,
    private val dataMapper: PokemonDataMapper,
    private val pokemonRemoteDataSource: PokemonRemoteDataSource,
    private val pokemonLocalDataSource: PokemonLocalDataSource
) : PokemonRepository {

    override fun getPokemonList(): Flow<List<Pokemon>> = flow {
        val localData = pokemonLocalDataSource.getPokemonList()

        if(localData != null && localData.isNotEmpty()){
            //Emite datos locales
            emit(localData)
        } else {
            //Si no hay datos locales, obtiene los remotos
            val remoteData = pokemonRemoteDataSource.getPokemonList()
            //Mapea y emite los datos remotos
            val mappedData = remoteData.mapNotNull { dataMapper.mapPokemonDTOToPokemon(it) }
            emit(mappedData)
        }
    }

    override fun getPokemonDetail(pokemonId: String): Flow<Pokemon> = flow {
        val dittoJson = getDittoJson()
        val dto = Gson().fromJson(dittoJson, PokemonDTO::class.java)
        val pokemon = dataMapper.mapPokemonDTOToPokemon(dto)
        emit(pokemon ?: throw Exception("Pokemon no encontrado"))
    }

    // Asumiendo que ditto.json está en la carpeta assets, que lo está
    private fun getDittoJson(): String {
        val inputStream = javaClass.classLoader?.getResourceAsStream("assets/ditto.json")
        val reader = InputStreamReader(inputStream)
        return reader.readText()
    }
}


/* Antes de pasar la lógica de leer ditto.json a PokemonLocalDataSource
    override fun getPokemonList(): Flow<List<Pokemon>> = flow {
        val localData = loadPokemonFromAssets(context)

        if(localData != null){
            //Emite datos locales
            emit(listOf(localData))
        } else {
            //Si no hay datos locales, obtiene los remotos
            val remoteData = pokemonRemoteDataSource.getPokemonList()
            //Mapea y emite los datos remotos
            val mappedData = remoteData.mapNotNull { dataMapper.mapPokemonDTOToPokemon(it) }
            emit(mappedData)
        }
    }

    fun loadPokemonFromAssets(context: Context): Pokemon? {
        val inputStream = context.assets.open("ditto.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        return Gson().fromJson(json, Pokemon::class.java)
    }

 */