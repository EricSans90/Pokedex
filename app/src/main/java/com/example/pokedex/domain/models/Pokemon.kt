package com.example.pokedex.domain.models

//Clase que representa un Pokémon

data class Pokemon(
    val abilities: List<Ability>,
    val baseExperience: Int,
    val forms: List<NamedApiResource>,
    val gameIndices: List<Unit>,
    val height: Int,
    val heldItems: List<HeldItem>,
    val id: Int,
    val isDefault: Boolean,
    val locationAreaEncounters: String,
    val moves: List<Move>,
    val sprites: PokemonSprites,
    val name: String,
    val order:Int,
    val species: NamedApiResource,
    val stats: List<PokemonStat>,
    val types: List<PokemonType>,
    val weight: Int
)