package com.example.pokedex.data.sources.remote

import com.example.pokedex.data.models.PokemonDTO
import javax.inject.Inject

//Fuente de datos remota para Pokémon

class PokemonRemoteDataSource @Inject constructor(private val apiService: PokemonApiService) {
    suspend fun getPokemonList(): List<PokemonDTO> {
        val response = apiService.getPokemonList()
        return response.results

        // Simular llamada a API leyendo el archivo JSON
        //return listOf(apiService.getPokemonDetail("ditto"))
    }
    fun getPokemonDetail(pokemonName: String): PokemonDTO {
        return apiService.getPokemonDetail(pokemonName)
    }
}