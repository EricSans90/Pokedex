package com.example.pokedex.domain.models

data class HeldItem(
    val item: NamedApiResource,
    val versionDetails: List<VersionDetail>
)