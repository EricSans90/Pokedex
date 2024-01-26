package com.example.pokedex.ui.screens

//Para mostrar la lista de Pokémon

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.pokedex.ui.viewmodels.PokemonListViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokedex.ui.components.PokemonListItem
import com.example.pokedex.ui.theme.backGr
import com.example.pokedex.ui.theme.redList

@Composable
fun PokemonListScreen(onPokemonSelected: (String) -> Unit) {
    val viewModel: PokemonListViewModel = hiltViewModel()
    val pokemonList = viewModel.pokemonList.observeAsState(initial = emptyList())

    Surface(color = backGr){
        LazyColumn {
            items(pokemonList.value) { pokemon ->
                PokemonListItem(pokemon, Modifier.clickable { onPokemonSelected(pokemon.name) })
            }
        }
    }
}