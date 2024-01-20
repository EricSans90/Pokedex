package com.example.pokedex.domain.models

data class PokemonStat(
    val stat: NamedApiResource,
    val effort: Int,
    val baseStat: Int
)