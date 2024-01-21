package com.example.pokedex.ui.screens

//Para mostrar los detalles de un Pokémon específico

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokedex.ui.components.PokemonDetailView
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun PokemonDetailScreen() {
    //lógica para mostrar los detalles del Pokémon usando el ViewModel
    val viewModel: PokemonDetailViewModel = viewModel()
    // Usar observeAsState para LiveData
    val pokemon by viewModel.pokemonDetails.observeAsState()

    pokemon?.let { currentPokemon ->
        PokemonDetailView(pokemon = currentPokemon)
    }
}


