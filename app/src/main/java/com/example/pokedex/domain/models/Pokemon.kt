package com.example.pokedex.domain.models

//Clase que representa un Pokémon

data class Pokemon(
    val abilities: List<Ability>,
    val baseExperience: Int,
    val forms: List<NamedApiResource>,
    val gameIndices: List<VersionGameIndex>,
    val height: Int,
    val heldItems: List<HeldItem>,
    val id: Int,
    val isDefault: Boolean,
    val locationAreaEncounters: String,
    val moves: List<Move>,
    val name: String,
    val order:Int,
    val pastAbilities: List<Ability>,
    val pastTypes: List<PokemonType>,
    val species: NamedApiResource,
    val sprites: PokemonSprites,
    val stats: List<PokemonStat>,
    val types: List<PokemonType>,
    val weight: Int
)