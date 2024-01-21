package com.example.pokedex.data.mappers

//Para convertir PokemonDTO a Pokemon

import com.example.pokedex.data.models.*
import com.example.pokedex.domain.models.*


class PokemonDataMapper {

    fun mapPokemonDTOToPokemon(dto: PokemonDTO): Pokemon {
        return Pokemon(
            abilities = dto.abilities.map { mapAbilityDTOToAbility(it) },
            baseExperience = dto.base_experience,
            forms = dto.forms.map { mapNamedApiResourceDTOToNamedApiResource(it) },
            gameIndices = dto.game_indices.map { mapVersionGameIndexDTOToVersionGameIndex(it) },
            height = dto.height,
            heldItems = dto.held_items.map { mapHeldItemDTOToHeldItem(it) },
            id = dto.id,
            isDefault = dto.is_default,
            locationAreaEncounters = dto.location_area_encounters,
            moves = dto.moves.map { mapMoveDTOToMove(it) },
            name = dto.name,
            order = dto.order,
            pastAbilities = dto.past_abilities.map { mapAbilityDTOToAbility(it) },
            pastTypes = dto.past_types.map { mapPokemonTypeDTOToPokemonType(it) },
            species = mapNamedApiResourceDTOToNamedApiResource(dto.species),
            sprites = mapPokemonSpritesDTOToPokemonSprites(dto.sprites),
            stats = dto.stats.map { mapPokemonStatDTOToPokemonStat(it) },
            types = dto.types.map { mapPokemonTypeDTOToPokemonType(it) },
            weight = dto.weight
        )
    }

    fun mapAbilityDTOToAbility(dto: PokemonAbilityDTO): Ability {
        return Ability(
            ability = mapNamedApiResourceDTOToNamedApiResource(dto.ability),
            isHidden = dto.is_hidden,
            slot = dto.slot
        )
    }

    fun mapNamedApiResourceDTOToNamedApiResource(dto: NamedApiResourceDTO): NamedApiResource {
        return NamedApiResource(
            name = dto.name,
            url = dto.url
        )
    }

    fun mapVersionGameIndexDTOToVersionGameIndex(dto: VersionGameIndexDTO): VersionGameIndex {
        return VersionGameIndex(
            gameIndex = dto.game_index,
            version = mapNamedApiResourceDTOToNamedApiResource(dto.version)
        )
    }

    fun mapHeldItemDTOToHeldItem(dto: PokemonHeldItemDTO): HeldItem {
        return HeldItem(
            item = mapNamedApiResourceDTOToNamedApiResource(dto.item),
            versionDetails = dto.version_details.map { mapVersionDetailDTOToVersionDetail(it) }
        )
    }

    fun mapVersionDetailDTOToVersionDetail(dto: PokemonHeldItemVersionDTO): VersionDetail {
        return VersionDetail(
            rarity = dto.rarity,
            version = mapNamedApiResourceDTOToNamedApiResource(dto.version)
        )
    }

    fun mapMoveDTOToMove(dto: PokemonMoveDTO): Move {
        return Move(
            move = mapNamedApiResourceDTOToNamedApiResource(dto.move),
            versionGroupDetails = dto.version_group_details.map { mapVersionGroupDetailDTOToVersionGroupDetail(it) }
        )
    }

    fun mapVersionGroupDetailDTOToVersionGroupDetail(dto: PokemonMoveVersionDTO): VersionGroupDetail {
        return VersionGroupDetail(
            levelLearnedAt = dto.level_learned_at,
            moveLearnMethod = mapNamedApiResourceDTOToNamedApiResource(dto.move_learn_method),
            versionGroup = mapNamedApiResourceDTOToNamedApiResource(dto.version_group)
        )
    }

    fun mapPokemonSpritesDTOToPokemonSprites(dto: PokemonSpritesDTO): PokemonSprites {
        return PokemonSprites(
            backDefault = dto.back_default,
            backFemale = dto.back_female,
            backShiny = dto.back_shiny,
            backShinyFemale = dto.back_shiny_female,
            frontDefault = dto.front_default,
            frontFemale = dto.front_female,
            frontShiny = dto.front_shiny,
            frontShinyFemale = dto.front_shiny_female,
            other = dto.other?.let { mapOtherSpritesDTOToOtherSprites(it) },
            versions = dto.versions?.let { mapGenerationSpritesDTOToGenerationSprites(it) }
        )
    }

    fun mapOtherSpritesDTOToOtherSprites(dto: OtherSpritesDTO): OtherSprites {
        return OtherSprites(
            dreamWorld = dto.dream_world?.let { mapDreamWorldSpritesDTOToDreamWorldSprites(it) },
            home = dto.home?.let { mapHomeSpritesDTOToHomeSprites(it) },
            officialArtwork = dto.official_artwork?.let { mapOfficialArtworkSpritesDTOToOfficialArtworkSprites(it) }
        )
    }

    fun mapDreamWorldSpritesDTOToDreamWorldSprites(dto: DreamWorldSpritesDTO): DreamWorldSprites {
        return DreamWorldSprites(
            frontDefault = dto.front_default,
            frontFemale = dto.front_female
        )
    }

    fun mapHomeSpritesDTOToHomeSprites(dto: HomeSpritesDTO): HomeSprites {
        return HomeSprites(
            frontDefault = dto.front_default,
            frontFemale = dto.front_female,
            frontShiny = dto.front_shiny,
            frontShinyFemale = dto.front_shiny_female
        )
    }

    fun mapOfficialArtworkSpritesDTOToOfficialArtworkSprites(dto: OfficialArtworkSpritesDTO): OfficialArtworkSprites {
        return OfficialArtworkSprites(
            frontDefault = dto.front_default,
            frontShiny = dto.front_shiny
        )
    }

    fun mapPokemonStatDTOToPokemonStat(dto: PokemonStatDTO): PokemonStat {
        return PokemonStat(
            baseStat = dto.base_stat,
            effort = dto.effort,
            stat = mapNamedApiResourceDTOToNamedApiResource(dto.stat)
        )
    }

    fun mapPokemonTypeDTOToPokemonType(dto: PokemonTypeDTO): PokemonType {
        return PokemonType(
            slot = dto.slot,
            type = mapNamedApiResourceDTOToNamedApiResource(dto.type)
        )
    }

    fun mapGenerationSpritesDTOToGenerationSprites(dto: VersionsSpritesDTO): GenerationSprites {
        return GenerationSprites(
            generationI = dto.generation_i?.let { mapGenerationISpritesDTOToGenerationISprites(it) },
            generationII = dto.generation_ii?.let { mapGenerationIISpritesDTOToGenerationIISprites(it) },
            generationIII = dto.generation_iii?.let { mapGenerationIIISpritesDTOToGenerationIIISprites(it) },
            generationIV = dto.generation_iv?.let { mapGenerationIVSpritesDTOToGenerationIVSprites(it) },
            generationV = dto.generation_v?.let { mapGenerationVSpritesDTOToGenerationVSprites(it) },
            generationVI = dto.generation_vi?.let { mapGenerationVISpritesDTOToGenerationVISprites(it) },
            generationVII = dto.generation_vii?.let { mapGenerationVIISpritesDTOToGenerationVIISprites(it) },
            generationVIII = dto.generation_viii?.let { mapGenerationVIIISpritesDTOToGenerationVIIISprites(it) }
        )
    }

    fun mapGenerationISpritesDTOToGenerationISprites(dto: GenerationISpritesDTO): GenerationISprites {
        return GenerationISprites(
            redBlue = dto.red_blue?.let { mapRedBlueSpritesDTOToRedBlueSprites(it) },
            yellow = dto.yellow?.let { mapYellowSpritesDTOToYellowSprites(it) }
        )
    }

    fun mapRedBlueSpritesDTOToRedBlueSprites(dto: RedBlueSpritesDTO): RedBlueSprites {
        return RedBlueSprites(
            backDefault = dto.back_default,
            backGray = dto.back_gray,
            backTransparent = dto.back_transparent,
            frontDefault = dto.front_default,
            frontGray = dto.front_gray,
            frontTransparent = dto.front_transparent
        )
    }

    fun mapYellowSpritesDTOToYellowSprites(dto: YellowSpritesDTO): YellowSprites {
        return YellowSprites(
            backDefault = dto.back_default,
            backGray = dto.back_gray,
            backTransparent = dto.back_transparent,
            frontDefault = dto.front_default,
            frontGray = dto.front_gray,
            frontTransparent = dto.front_transparent
        )
    }

    fun mapGenerationIISpritesDTOToGenerationIISprites(dto: GenerationIISpritesDTO): GenerationIISprites {
        return GenerationIISprites(
            crystal = dto.crystal?.let { mapCrystalSpritesDTOToCrystalSprites(it) },
            gold = dto.gold?.let { mapGoldSilverSpritesDTOToGoldSilverSprites(it) },
            silver = dto.silver?.let { mapGoldSilverSpritesDTOToGoldSilverSprites(it) }
        )
    }

    fun mapCrystalSpritesDTOToCrystalSprites(dto: CrystalSpritesDTO): CrystalSprites {
        return CrystalSprites(
            backDefault = dto.back_default,
            backShiny = dto.back_shiny,
            backShinyTransparent = dto.back_shiny_transparent,
            backTransparent = dto.back_transparent,
            frontDefault = dto.front_default,
            frontShiny = dto.front_shiny,
            frontShinyTransparent = dto.front_shiny_transparent,
            frontTransparent = dto.front_transparent
        )
    }

    fun mapGoldSilverSpritesDTOToGoldSilverSprites(dto: GoldSilverSpritesDTO): GoldSilverSprites {
        return GoldSilverSprites(
            backDefault = dto.back_default,
            backShiny = dto.back_shiny,
            frontDefault = dto.front_default,
            frontShiny = dto.front_shiny,
            frontTransparent = dto.front_transparent
        )
    }

    fun mapGenerationIIISpritesDTOToGenerationIIISprites(dto: GenerationIIISpritesDTO): GenerationIIISprites {
        return GenerationIIISprites(
            emerald = dto.emerald?.let { mapEmeraldSpritesDTOToEmeraldSprites(it) },
            fireredLeafgreen = dto.firered_leafgreen?.let { mapFireRedLeafGreenSpritesDTOToFireRedLeafGreenSprites(it) },
            rubySapphire = dto.ruby_sapphire?.let { mapRubySapphireSpritesDTOToRubySapphireSprites(it) }
        )
    }

    fun mapEmeraldSpritesDTOToEmeraldSprites(dto: EmeraldSpritesDTO): EmeraldSprites {
        return EmeraldSprites(
            frontDefault = dto.front_default,
            frontShiny = dto.front_shiny
        )
    }

    fun mapFireRedLeafGreenSpritesDTOToFireRedLeafGreenSprites(dto: FireRedLeafGreenSpritesDTO): FireRedLeafGreenSprites {
        return FireRedLeafGreenSprites(
            backDefault = dto.back_default,
            backShiny = dto.back_shiny,
            frontDefault = dto.front_default,
            frontShiny = dto.front_shiny
        )
    }

    fun mapRubySapphireSpritesDTOToRubySapphireSprites(dto: RubySapphireSpritesDTO): RubySapphireSprites {
        return RubySapphireSprites(
            backDefault = dto.back_default,
            backShiny = dto.back_shiny,
            frontDefault = dto.front_default,
            frontShiny = dto.front_shiny
        )
    }

    fun mapGenerationIVSpritesDTOToGenerationIVSprites(dto: GenerationIVSpritesDTO): GenerationIVSprites {
        return GenerationIVSprites(
            diamondPearl = dto.diamond_pearl?.let { mapDiamondPearlSpritesDTOToDiamondPearlSprites(it) },
            heartgoldSoulsilver = dto.heartgold_soulsilver?.let { mapHeartGoldSoulSilverSpritesDTOToHeartGoldSoulSilverSprites(it) },
            platinum = dto.platinum?.let { mapPlatinumSpritesDTOToPlatinumSprites(it) }
        )
    }

    fun mapDiamondPearlSpritesDTOToDiamondPearlSprites(dto: DiamondPearlSpritesDTO): DiamondPearlSprites {
        return DiamondPearlSprites(
            backDefault = dto.back_default,
            backFemale = dto.back_female,
            backShiny = dto.back_shiny,
            backShinyFemale = dto.back_shiny_female,
            frontDefault = dto.front_default,
            frontFemale = dto.front_female,
            frontShiny = dto.front_shiny,
            frontShinyFemale = dto.front_shiny_female
        )
    }

    fun mapHeartGoldSoulSilverSpritesDTOToHeartGoldSoulSilverSprites(dto: HeartGoldSoulSilverSpritesDTO): HeartGoldSoulSilverSprites {
        return HeartGoldSoulSilverSprites(
            backDefault = dto.back_default,
            backFemale = dto.back_female,
            backShiny = dto.back_shiny,
            backShinyFemale = dto.back_shiny_female,
            frontDefault = dto.front_default,
            frontFemale = dto.front_female,
            frontShiny = dto.front_shiny,
            frontShinyFemale = dto.front_shiny_female
        )
    }

    fun mapPlatinumSpritesDTOToPlatinumSprites(dto: PlatinumSpritesDTO): PlatinumSprites {
        return PlatinumSprites(
            backDefault = dto.back_default,
            backFemale = dto.back_female,
            backShiny = dto.back_shiny,
            backShinyFemale = dto.back_shiny_female,
            frontDefault = dto.front_default,
            frontFemale = dto.front_female,
            frontShiny = dto.front_shiny,
            frontShinyFemale = dto.front_shiny_female
        )
    }

    fun mapGenerationVSpritesDTOToGenerationVSprites(dto: GenerationVSpritesDTO): GenerationVSprites {
        return GenerationVSprites(
            blackWhite = dto.black_white?.let { mapBlackWhiteSpritesDTOToBlackWhiteSprites(it) }
        )
    }

    fun mapBlackWhiteSpritesDTOToBlackWhiteSprites(dto: BlackWhiteSpritesDTO): BlackWhiteSprites {
        return BlackWhiteSprites(
            animated = dto.animated?.let { mapAnimatedSpritesDTOToAnimatedSprites(it) },
            backDefault = dto.back_default,
            backFemale = dto.back_female,
            backShiny = dto.back_shiny,
            backShinyFemale = dto.back_shiny_female,
            frontDefault = dto.front_default,
            frontFemale = dto.front_female,
            frontShiny = dto.front_shiny,
            frontShinyFemale = dto.front_shiny_female
        )
    }

    fun mapAnimatedSpritesDTOToAnimatedSprites(dto: AnimatedSpritesDTO): AnimatedSprites {
        return AnimatedSprites(
            backDefault = dto.back_default,
            backFemale = dto.back_female,
            backShiny = dto.back_shiny,
            backShinyFemale = dto.back_shiny_female,
            frontDefault = dto.front_default,
            frontFemale = dto.front_female,
            frontShiny = dto.front_shiny,
            frontShinyFemale = dto.front_shiny_female
        )
    }

    fun mapGenerationVISpritesDTOToGenerationVISprites(dto: GenerationVISpritesDTO): GenerationVISprites {
        return GenerationVISprites(
            omegarubyAlphasapphire = dto.omegaruby_alphasapphire?.let { mapOmegarubyAlphasapphireSpritesDTOToOmegarubyAlphasapphireSprites(it) },
            xy = dto.x_y?.let { mapXYSpritesDTOToXYSprites(it) }
        )
    }

    fun mapOmegarubyAlphasapphireSpritesDTOToOmegarubyAlphasapphireSprites(dto: OmegarubyAlphasapphireSpritesDTO): OmegarubyAlphasapphireSprites {
        return OmegarubyAlphasapphireSprites(
            frontDefault = dto.front_default,
            frontFemale = dto.front_female,
            frontShiny = dto.front_shiny,
            frontShinyFemale = dto.front_shiny_female
        )
    }

    fun mapXYSpritesDTOToXYSprites(dto: XYSpritesDTO): XYSprites {
        return XYSprites(
            frontDefault = dto.front_default,
            frontFemale = dto.front_female,
            frontShiny = dto.front_shiny,
            frontShinyFemale = dto.front_shiny_female
        )
    }

    fun mapGenerationVIISpritesDTOToGenerationVIISprites(dto: GenerationVIISpritesDTO): GenerationVIISprites {
        return GenerationVIISprites(
            icons = dto.icons?.let { mapIconsSpritesDTOToIconsSprites(it) },
            ultraSunUltraMoon = dto.ultra_sun_ultra_moon?.let { mapUltraSunUltraMoonSpritesDTOToUltraSunUltraMoonSprites(it) }
        )
    }

    fun mapIconsSpritesDTOToIconsSprites(dto: IconsSpritesDTO): IconsSprites {
        return IconsSprites(
            frontDefault = dto.front_default,
            frontFemale = dto.front_female
        )
    }

    fun mapUltraSunUltraMoonSpritesDTOToUltraSunUltraMoonSprites(dto: UltraSunUltraMoonSpritesDTO): UltraSunUltraMoonSprites {
        return UltraSunUltraMoonSprites(
            frontDefault = dto.front_default,
            frontFemale = dto.front_female,
            frontShiny = dto.front_shiny,
            frontShinyFemale = dto.front_shiny_female
        )
    }

    fun mapGenerationVIIISpritesDTOToGenerationVIIISprites(dto: GenerationVIIISpritesDTO): GenerationVIIISprites {
        return GenerationVIIISprites(
            icons = dto.icons?.let { mapIconsSpritesDTOToIconsSprites(it) }
        )
    }

}