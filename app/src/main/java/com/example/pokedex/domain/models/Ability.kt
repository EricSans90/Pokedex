package com.example.pokedex.domain.models

data class Ability (
    val ability: NamedApiResource,
    val isHidden: Boolean,
    val slot: Int
)