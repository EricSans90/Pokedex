package com.example.pokedex.ui.screens

//Para mostrar los detalles de un Pokémon específico

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokedex.ui.components.PokemonDetailView
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PokemonDetailScreen(pokemonName: String) {
    //lógica para mostrar los detalles del Pokémon usando el ViewModel
    val viewModel: PokemonDetailViewModel = hiltViewModel()
    // Usar observeAsState para LiveData
    val pokemon by viewModel.pokemonDetails.observeAsState()

    pokemon?.let { currentPokemon ->
        PokemonDetailView(pokemon = currentPokemon)
    }
}


