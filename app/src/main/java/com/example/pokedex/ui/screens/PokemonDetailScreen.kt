package com.example.pokedex.ui.screens

//Para mostrar los detalles de un Pokémon específico

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokedex.ui.components.PokemonDetailView
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pokedex.data.sources.remote.PokemonApiService

@Composable
fun PokemonDetailScreen(pokemonName: String, navController: NavController) {
    val viewModel: PokemonDetailViewModel = hiltViewModel()
    val pokemon by viewModel.getPokemonDetail(pokemonName).observeAsState()

    pokemon?.let { currentPokemon ->
        PokemonDetailView(pokemon = currentPokemon,  navController = navController)
    }
}
    /*
    //Para probar si funciona:

    val pokemonApiService = PokemonApiService(LocalContext.current)
    val pokemonDto = pokemonApiService.getPokemonDetail(pokemonName)

    // Muestra el nombre del Pokémon
    Text(text = "Pokemon: ${pokemonDto.name}")

    //efectivamente sí funciona

}
*/

