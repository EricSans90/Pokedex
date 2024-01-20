package com.example.pokedex.domain.models

data class Move(
    val move: NamedApiResource,
    val versionGroupDetails: List<VersionGroupDetail>
)