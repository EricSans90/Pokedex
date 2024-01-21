package com.example.pokedex.data.sources.remote

//Fuente de datos remota para Pokémon

class PokemonRemoteDataSource(private val apiService: PokemonApiService) {
    // fun getPokemonList() = apiService.getPokemonList()
    fun getPokemonDetail(pokemonId: String) = apiService.getPokemonDetail(pokemonId)
}