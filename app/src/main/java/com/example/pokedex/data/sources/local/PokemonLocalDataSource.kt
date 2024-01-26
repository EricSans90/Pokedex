package com.example.pokedex.data.sources.local

import android.content.Context
import com.example.pokedex.domain.models.Pokemon
import com.google.gson.Gson
import javax.inject.Inject

//Fuente de datos local para Pokémon

//De momento no voy a implementarlo, pero de seguir ampliando el proyecto
//no habría ningún problema

class PokemonLocalDataSource@Inject constructor(private val context: Context){
    // Método para obtener la lista de Pokémon desde la base de datos local
    // Retorna null si aún no está implementado o no hay datos
    fun getPokemonList(): List<Pokemon>? {
        //Lógica para consultar la BD
        //no está implementada retorna null
        //return null
        //Pongo aquí mi lógica provisional de cargar al ditto.json
        return try{
            val inputStream = context.assets.open("ditto.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val json = String(buffer, Charsets.UTF_8)
            listOf(Gson().fromJson(json, Pokemon::class.java))
        } catch (e: Exception){
            //en casod e error retornamos null
            null
        }
    }

    // Método para detalles de un pokémon específico
    fun getPokemonDetail(pokemonId: String): Pokemon?{
        //Lógica para consultar la BD y obtener detalles del pokemon
        return null
    }

    //Método para guardar la lista pokemon en la BD
    fun savePokemonList(pokemonList: List<Pokemon>){
        //Lógica de guardado de una lista de pokemon en la BD local
    }

    //Método para guardar la lista pokemon en la BD
    fun savePokemonDetail(pokemon: Pokemon){
        //Lógica de guardado de detalles de pokemon en la BD local
    }

    //Otros métodos que nos puediesen hacer falta
}