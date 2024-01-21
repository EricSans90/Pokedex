package com.example.pokedex.data.mappers

//Para convertir PokemonDTO a Pokemon

import com.example.pokedex.data.models.NamedApiResourceDTO
import com.example.pokedex.data.models.PokemonAbilityDTO
import com.example.pokedex.data.models.PokemonDTO
import com.example.pokedex.data.models.PokemonStatDTO
import com.example.pokedex.data.models.PokemonTypeDTO
import com.example.pokedex.domain.models.Ability
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonStat
import com.example.pokedex.domain.models.PokemonType

class PokemonDataMapper {

    fun dtoToDomain(dto: PokemonDTO): Pokemon {
        return Pokemon(
            id = dto.id,
            name = dto.name,
            baseExperience = dto.base_experience,
            height = dto.height,
            isDefault = dto.is_default,
            order = dto.order,
            weight = dto.weight,
            abilities = dto.abilities.map { it.toDomainModel() },
            forms = dto.forms.map { it.toDomainModel() },
            gameIndices = dto.game_indices.map { it.toDomainModel() },
            heldItems = dto.held_items.map { it.toDomainModel() },
            locationAreaEncounters = dto.location_area_encounters,
            moves = dto.moves.map { it.toDomainModel() },
            sprites = dto.sprites.toDomainModel(),
            species = dto.species.toDomainModel(),
            stats = dto.stats.map { it.toDomainModel() },
            types = dto.types.map { it.toDomainModel() }
        )
    }

    private fun PokemonAbilityDTO.toDomainModel(): Ability {
        return Ability(
            ability = this.ability.toDomainModel(),
            isHidden = this.is_hidden,
            slot = this.slot
        )
    }

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
}