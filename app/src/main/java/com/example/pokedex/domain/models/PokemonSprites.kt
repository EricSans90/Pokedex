package com.example.pokedex.domain.models

data class PokemonSprites(
    val backDefault: String?,
    val backFemale: String?,
    val backShiny: String?,
    val backShinyFemale: String?,
    val frontDefault: String?,
    val frontFemale: String?,
    val frontShiny: String?,
    val frontShinyFemale: String?,
    val other: OtherSprites?,
    val versions: GenerationSprites?
)