package com.example.pokedex.data.sources.remote

//Para interactuar con la API de Pokémon

import com.example.pokedex.data.models.PokemonDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService{
    @GET("pokemon")
    suspend fun getPokemonList(): List<PokemonDTO>

    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(pokemonId: Int): @Path("id") pokemonId: Int): PokemonDTO
}