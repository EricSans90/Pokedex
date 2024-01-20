package com.example.pokedex.domain.models

data class VersionGroupDetail(
    val levelLearnedAt: Int,
    val moveLearnMethod: NamedApiResource,
    val versionGroup: NamedApiResource
)