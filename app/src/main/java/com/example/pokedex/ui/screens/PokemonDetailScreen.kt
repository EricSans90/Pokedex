package com.example.pokedex.ui.screens

//Para mostrar los detalles de un Pokémon específico

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokedex.ui.components.PokemonDetailView
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel

@Composable
fun PokemonDetailScreen() {
    //lógica para mostrar los detalles del Pokémon usando el ViewModel
    val viewModel: PokemonDetailViewModel = viewModel()
    val pokemon = viewModel.pokemonDetails.collectAsState(initial = null).value

    pokemon?.let {
        PokemonDetailView(pokemon = it)
    }
}


