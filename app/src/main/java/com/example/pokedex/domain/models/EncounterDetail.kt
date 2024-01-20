package com.example.pokedex.domain.models

data class EncounterDetail(
    val minLevel: Int,
    val maxLevel: Int,
    val encounterType: NamedApiResource,
    val chance: Int,
    val method: NamedApiResource
)