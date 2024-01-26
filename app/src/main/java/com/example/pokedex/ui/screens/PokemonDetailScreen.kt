package com.example.pokedex.ui.screens

//Para mostrar los detalles de un Pokémon específico

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.pokedex.ui.components.PokemonDetailView
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun PokemonDetailScreen(pokemonName: String, navController: NavController) {
    val viewModel: PokemonDetailViewModel = hiltViewModel()
    val pokemon by viewModel.getPokemonDetail(pokemonName).observeAsState()

    pokemon?.let { currentPokemon ->
        PokemonDetailView(pokemon = currentPokemon,  navController = navController)
    }
}

