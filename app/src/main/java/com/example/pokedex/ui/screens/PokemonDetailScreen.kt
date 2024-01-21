package com.example.pokedex.ui.screens

//Para mostrar los detalles de un Pokémon específico

import androidx.compose.runtime.Composable
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel

@Composable
fun PokemonDetailScreen(viewModel: PokemonDetailViewModel, pokemonId: Int) {
    //lógica para mostrar los detalles del Pokémon usando el ViewModel
    // pasamos el ID del Pokémon al ViewModel para que pueda cargar los detalles

}