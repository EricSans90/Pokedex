package com.example.pokedex.data.models

import com.google.gson.annotations.SerializedName

//Representa la estructura de datos como se recibe de la API

data class PokemonDTO(
    val abilities: List<PokemonAbilityDTO>,
    val base_experience: Int,
    val forms: List<NamedApiResourceDTO>,
    val game_indices: List<VersionGameIndexDTO>,
    val height: Int,
    val held_items: List<PokemonHeldItemDTO>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<PokemonMoveDTO>,
    val name: String,
    val order: Int,
    val past_abilities: List<PokemonAbilityDTO>,
    val past_types: List<PokemonTypeDTO>,
    val species: NamedApiResourceDTO,
    val sprites: PokemonSpritesDTO,
    val stats: List<PokemonStatDTO>,
    val types: List<PokemonTypeDTO>,
    val weight: Int,
)

data class PokemonAbilityDTO(
    val ability: NamedApiResourceDTO,
    val is_hidden: Boolean,
    val slot: Int,
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
    val rarity: Int,
    val version: NamedApiResourceDTO,

)

data class PokemonMoveDTO(
    val move: NamedApiResourceDTO,
    val version_group_details: List<PokemonMoveVersionDTO>
)

data class PokemonMoveVersionDTO(
    val level_learned_at: Int,
    val move_learn_method: NamedApiResourceDTO,
    val version_group: NamedApiResourceDTO,

)

data class PokemonSpritesDTO(
    val back_default: String?,
    val back_female: String?,
    val back_shiny: String?,
    val back_shiny_female: String?,
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?,
    val other:OtherSpritesDTO?,
    val versions:VersionsSpritesDTO?,
)

data class OtherSpritesDTO(
    val dream_world: DreamWorldSpritesDTO?,
    val home: HomeSpritesDTO?,
    @SerializedName("official-artwork")
    val official_artwork: OfficialArtworkSpritesDTO?
)

data class DreamWorldSpritesDTO(
    val front_default: String?,
    val front_female: String?
)

data class HomeSpritesDTO(
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
)

data class OfficialArtworkSpritesDTO(
    val front_default: String?,
    val front_shiny: String?
)

data class PokemonStatDTO(
    val base_stat: Int,
    val effort: Int,
    val stat: NamedApiResourceDTO,
)

data class PokemonTypeDTO(
    val slot: Int,
    val type: NamedApiResourceDTO
)

data class VersionsSpritesDTO(
    @SerializedName("generation-i")
    val generation_i: GenerationISpritesDTO?,
    @SerializedName("generation-ii")
    val generation_ii: GenerationIISpritesDTO?,
    @SerializedName("generation-iii")
    val generation_iii: GenerationIIISpritesDTO?,
    @SerializedName("generation-iv")
    val generation_iv: GenerationIVSpritesDTO?,
    @SerializedName("generation-v")
    val generation_v: GenerationVSpritesDTO?,
    @SerializedName("generation-vi")
    val generation_vi: GenerationVISpritesDTO?,
    @SerializedName("generation-vii")
    val generation_vii: GenerationVIISpritesDTO?,
    @SerializedName("generation-viii")
    val generation_viii: GenerationVIIISpritesDTO?
)

data class GenerationISpritesDTO(
    @SerializedName("red-blue")
    val red_blue: RedBlueSpritesDTO?,
    val yellow: YellowSpritesDTO?
)

data class RedBlueSpritesDTO(
    val back_default: String?,
    val back_gray: String?,
    val back_transparent: String?,
    val front_default: String?,
    val front_gray: String?,
    val front_transparent: String?
)

data class YellowSpritesDTO(
    val back_default: String?,
    val back_gray: String?,
    val back_transparent: String?,
    val front_default: String?,
    val front_gray: String?,
    val front_transparent: String?
)

data class GenerationIISpritesDTO(
    val crystal: CrystalSpritesDTO?,
    val gold: GoldSilverSpritesDTO?,
    val silver: GoldSilverSpritesDTO?
)

data class CrystalSpritesDTO(
    val back_default: String?,
    val back_shiny: String?,
    val back_shiny_transparent: String?,
    val back_transparent: String?,
    val front_default: String?,
    val front_shiny: String?,
    val front_shiny_transparent: String?,
    val front_transparent: String?
)

data class GoldSilverSpritesDTO(
    val back_default: String?,
    val back_shiny: String?,
    val front_default: String?,
    val front_shiny: String?,
    val front_transparent: String?
)

data class GenerationIIISpritesDTO(
    val emerald: EmeraldSpritesDTO?,
    @SerializedName("firered-leafgreen")
    val firered_leafgreen: FireRedLeafGreenSpritesDTO?,
    @SerializedName("ruby-sapphire")
    val ruby_sapphire: RubySapphireSpritesDTO?
)

data class EmeraldSpritesDTO(
    val front_default: String?,
    val front_shiny: String?,
)

data class FireRedLeafGreenSpritesDTO(
    val back_default: String?,
    val back_shiny: String?,
    val front_default: String?,
    val front_shiny: String?,
)

data class RubySapphireSpritesDTO(
    val back_default: String?,
    val back_shiny: String?,
    val front_default: String?,
    val front_shiny: String?,
)

data class GenerationIVSpritesDTO(
    @SerializedName("diamond-pearl")
    val diamond_pearl: DiamondPearlSpritesDTO?,
    @SerializedName("heartgold-soulsilver")
    val heartgold_soulsilver: HeartGoldSoulSilverSpritesDTO?,
    val platinum: PlatinumSpritesDTO?
)

//Como son iguales los podría unificar, pero prefiero dejarlos
// sueltos por si hubiese alguna modificación individual de cada versión de cada genereción
data class DiamondPearlSpritesDTO(
    val back_default: String?,
    val back_female: String?,
    val back_shiny: String?,
    val back_shiny_female: String?,
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
)

data class HeartGoldSoulSilverSpritesDTO(
    val back_default: String?,
    val back_female: String?,
    val back_shiny: String?,
    val back_shiny_female: String?,
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
)

data class PlatinumSpritesDTO(
    val back_default: String?,
    val back_female: String?,
    val back_shiny: String?,
    val back_shiny_female: String?,
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
)

data class GenerationVSpritesDTO(
    @SerializedName("black-white")
    val black_white: BlackWhiteSpritesDTO?
)

data class BlackWhiteSpritesDTO(
    val animated: AnimatedSpritesDTO?,
    val back_default: String?,
    val back_female: String?,
    val back_shiny: String?,
    val back_shiny_female: String?,
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
)

data class AnimatedSpritesDTO(
    val back_default: String?,
    val back_female: String?,
    val back_shiny: String?,
    val back_shiny_female: String?,
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
)

data class GenerationVISpritesDTO(
    @SerializedName("omegaruby-alphasapphire")
    val omegaruby_alphasapphire: OmegarubyAlphasapphireSpritesDTO?,
    @SerializedName("x-y")
    val x_y: XYSpritesDTO?
)

data class OmegarubyAlphasapphireSpritesDTO(
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
)

data class XYSpritesDTO(
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
)

data class GenerationVIISpritesDTO(
    val icons: IconsSpritesDTO?,
    @SerializedName("ultra-sun-ultra-moon")
    val ultra_sun_ultra_moon: UltraSunUltraMoonSpritesDTO?
)

data class IconsSpritesDTO(
    val front_default: String?,
    val front_female: String?,
)

data class UltraSunUltraMoonSpritesDTO(
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
)

data class GenerationVIIISpritesDTO(
    val icons: IconsSpritesDTO?
)
