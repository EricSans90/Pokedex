package com.example.pokedex.data.util

import android.content.Context
import com.example.pokedex.domain.models.Pokemon
import com.google.gson.Gson

fun loadPokemonFromAssets(context: Context): Pokemon {
    val inputStream = context.assets.open("ditto.json")
    val size = inputStream.available()
    val buffer = ByteArray(size)
    inputStream.read(buffer)
    inputStream.close()
    val json = String(buffer, Charsets.UTF_8)
    return Gson().fromJson(json, Pokemon::class.java)
}