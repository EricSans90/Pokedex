package com.example.pokedex.ui.components

//Para representar un elemento individual en la lista

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pokedex.domain.models.Pokemon

@Composable
fun PokemonListItem(pokemon: Pokemon, clickable: Modifier) {
    // UI para un elemento de la lista
    Text(text = pokemon.name, modifier = clickable)
}