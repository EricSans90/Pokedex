package com.example.pokedex.domain.models

data class PokemonAbility(
    val name: String,
    val url: String,
    val isHidden: Boolean,
    val slot: Int
)