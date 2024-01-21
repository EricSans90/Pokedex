package com.example.pokedex.data.sources.remote

//Para interactuar con la API de Pokémon

import android.content.Context
import com.google.gson.Gson
import com.example.pokedex.data.models.PokemonDTO
import java.io.IOException

class PokemonApiService(private val context: Context) {
    private val gson = Gson()

    fun getPokemonDetail(pokemonName: String): PokemonDTO {
        val json = loadJSONFromAsset(pokemonName)
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