package com.example.pokedex.data.mappers

//Para convertir PokemonDTO a Pokemon

import com.example.pokedex.data.models.NamedApiResourceDTO
import com.example.pokedex.data.models.PokemonAbilityDTO
import com.example.pokedex.data.models.PokemonDTO
import com.example.pokedex.data.models.PokemonStatDTO
import com.example.pokedex.data.models.PokemonTypeDTO
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonStat
import com.example.pokedex.domain.models.PokemonType

fun PokemonDTO.toDomainModel() = Pokemon(
    id = this.id,
    name = this.name,
    baseExperience = this.base_experience,
    height = this.height,
    weight = this.weight,
    abilities = this.abilities.map { it.toDomainModel() },
    types = this.types.map { it.toDomainModel() },
    stats = this.stats.map { it.toDomainModel() }
)

fun PokemonAbilityDTO.toDomainModel() = PokemonAbility(
    isHidden = this.is_hidden,
    ability = this.ability.toDomainModel()
)

fun NamedApiResourceDTO.toDomainModel() = com.example.pokedex.domain.models.NamedApiResource(
    name = this.name,
    url = this.url
)

fun PokemonTypeDTO.toDomainModel() = PokemonType(
    slot = this.slot,
    type = this.type.toDomainModel()
)

fun PokemonStatDTO.toDomainModel() = PokemonStat(
    stat = this.stat.toDomainModel(),
    baseStat = this.base_stat,
    effort = this.effort
)