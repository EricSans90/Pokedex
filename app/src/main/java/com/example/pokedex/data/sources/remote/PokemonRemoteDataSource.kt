package com.example.pokedex.data.sources.remote

//Fuente de datos remota para Pokémon

class PokemonRemoteDataSource(private val apiService: PokemonApiService) {
    suspend fun getPokemonList() = apiService.getPokemonList()
    suspend fun getPokemonDetail(pokemonId: Int) = apiService.getPokemonDetail(pokemonId)
}