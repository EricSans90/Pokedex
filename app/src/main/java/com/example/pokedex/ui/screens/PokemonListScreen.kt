package com.example.pokedex.ui.screens

//Para mostrar la lista de Pokémon


import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.pokedex.ui.viewmodels.PokemonListViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokedex.ui.components.PokemonListItem

@Composable
fun PokemonListScreen(onPokemonSelected: (String) -> Unit) {

    //lógica para mostrar la lista de Pokémon usando el ViewModel
    val viewModel: PokemonListViewModel = hiltViewModel()
    val pokemonList = viewModel.pokemonList.observeAsState(initial = emptyList())

    LazyColumn {
        items(pokemonList.value) { pokemon ->
            //Text(text = pokemon.name, modifier = Modifier.clickable { onPokemonSelected(pokemon.name) })
            PokemonListItem(pokemon)
        }
    }
}