package com.example.pokedex.data.models

//Representa la estructura de datos como se recibe de la API

data class PokemonDTO(
    val id: Int,
    val name: String,
    val base_experience: Int,
    val height: Int,
    val is_default: Boolean,
    val order: Int,
    val weight: Int,
    val abilities: List<PokemonAbilityDTO>,
    val forms: List<NamedApiResourceDTO>,
    val game_indices: List<VersionGameIndexDTO>,
    val held_items: List<PokemonHeldItemDTO>,
    val location_area_encounters: String,
    val moves: List<PokemonMoveDTO>,
    val sprites: PokemonSpritesDTO,
    val species: NamedApiResourceDTO,
    val stats: List<PokemonStatDTO>,
    val types: List<PokemonTypeDTO>
)

data class PokemonAbilityDTO(
    val is_hidden: Boolean,
    val slot: Int,
    val ability: NamedApiResourceDTO
)

data class NamedApiResourceDTO(
    val name: String,
    val url: String
)

data class VersionGameIndexDTO(
    val game_index: Int,
    val version: NamedApiResourceDTO
)

data class PokemonHeldItemDTO(
    val item: NamedApiResourceDTO,
    val version_details: List<PokemonHeldItemVersionDTO>
)

data class PokemonHeldItemVersionDTO(
    val version: NamedApiResourceDTO,
    val rarity: Int
)

data class PokemonMoveDTO(
    val move: NamedApiResourceDTO,
    val version_group_details: List<PokemonMoveVersionDTO>
)

data class PokemonMoveVersionDTO(
    val move_learn_method: NamedApiResourceDTO,
    val version_group: NamedApiResourceDTO,
    val level_learned_at: Int
)

data class PokemonSpritesDTO(
    val front_default: String?,
    val front_shiny: String?,
    val front_female: String?,
    val front_shiny_female: String?,
    val back_default: String?,
    val back_shiny: String?,
    val back_female: String?,
    val back_shiny_female: String?

)

data class PokemonStatDTO(
    val stat: NamedApiResourceDTO,
    val effort: Int,
    val base_stat: Int
)

data class PokemonTypeDTO(
    val slot: Int,
    val type: NamedApiResourceDTO
)

