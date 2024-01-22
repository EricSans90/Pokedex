package com.example.pokedex.data.sources.remote

//Para interactuar con la API de Pokémon

import android.content.Context
import com.google.gson.Gson
import com.example.pokedex.data.models.PokemonDTO
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.io.IOException

interface PokemonApiService {
//class PokemonApiService(private val context: Context) {
    //private val gson = Gson()

    @GET("pokemon/{pokemonName}")
    fun getPokemonDetail(@Path("pokemonName") pokemonName: String): PokemonDTO

    @GET("pokemon")
    suspend fun getPokemonList(): PokemonListResponse
    companion object {
        private const val BASE_URL = "https://pokeapi.co/api/v2/"

        fun create(): PokemonApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(PokemonApiService::class.java)
        }
    }
}

data class PokemonListResponse(
    val results: List<PokemonDTO>
)

/*
Antiguo antes de retrofit2
class PokemonApiService(private val context: Context) {
    private val gson = Gson()

    fun getPokemonDetail(pokemonId: String): PokemonDTO {
        val json = loadJSONFromAsset(pokemonId)
        return gson.fromJson(json, PokemonDTO::class.java)
    }

    private fun loadJSONFromAsset(filename: String): String {
        val json: String?
        try {
            val inputStream = context.assets.open("$filename.json")
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }
}
 */