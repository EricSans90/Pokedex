package com.example.pokedex.domain.models

data class LocationAreaEncounter(
    val locationArea: NamedApiResource,
    val encounterDetails: List<EncounterDetail>
)