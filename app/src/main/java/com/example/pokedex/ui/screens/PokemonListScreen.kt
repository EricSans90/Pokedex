package com.example.pokedex.ui.screens

//Para mostrar la lista de Pokémon


import androidx.compose.runtime.Composable
import com.example.pokedex.ui.viewmodels.PokemonListViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PokemonListScreen(onPokemonSelected: (String) -> Unit) {

    //lógica para mostrar la lista de Pokémon usando el ViewModel
    val viewModel: PokemonListViewModel = hiltViewModel()
    //..
}