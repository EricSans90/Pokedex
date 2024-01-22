package com.example.pokedex.data.mappers

//Para convertir PokemonDTO a Pokemon

import com.example.pokedex.data.models.*
import com.example.pokedex.domain.models.*


class PokemonDataMapper {

    fun mapPokemonDTOToPokemon(dto: PokemonDTO): Pokemon? {
        return mapNamedApiResourceDTOToNamedApiResource(dto.species )?.let {
            Pokemon(
                abilities = dto.abilities?.mapNotNull { mapAbilityDTOToAbility(it) } ?: emptyList(),
                baseExperience = dto.base_experience,
                forms = dto.forms?.mapNotNull { mapNamedApiResourceDTOToNamedApiResource(it) } ?: emptyList(),
                gameIndices = dto.game_indices?.mapNotNull { mapVersionGameIndexDTOToVersionGameIndex(it) } ?: emptyList(),
                height = dto.height,
                heldItems = dto.held_items?.mapNotNull { mapHeldItemDTOToHeldItem(it) } ?: emptyList(),
                id = dto.id,
                isDefault = dto.is_default,
                locationAreaEncounters = dto.location_area_encounters,
                moves = dto.moves?.mapNotNull { mapMoveDTOToMove(it) } ?: emptyList(),
                name = dto.name,
                order = dto.order,
                pastAbilities = dto.past_abilities?.mapNotNull { mapAbilityDTOToAbility(it) } ?: emptyList(),
                pastTypes = dto.past_types?.mapNotNull { mapPokemonTypeDTOToPokemonType(it) } ?: emptyList(),
                species = it,
                sprites = dto.sprites?.let { mapPokemonSpritesDTOToPokemonSprites(it) } ?: return null,
                stats = dto.stats?.mapNotNull { mapPokemonStatDTOToPokemonStat(it) } ?: emptyList(),
                types = dto.types?.mapNotNull { mapPokemonTypeDTOToPokemonType(it) } ?: emptyList(),
                weight = dto.weight
            )
        }
    }

    fun mapAbilityDTOToAbility(dto: PokemonAbilityDTO?): Ability? {
        dto ?: return null
        return mapNamedApiResourceDTOToNamedApiResource(dto.ability)?.let {
            Ability(
                ability = it,
                isHidden = dto.is_hidden,
                slot = dto.slot
            )
        }
    }

    fun mapNamedApiResourceDTOToNamedApiResource(dto: NamedApiResourceDTO?): NamedApiResource? {
        dto ?: return null
        return NamedApiResource(
            name = dto.name,
            url = dto.url
        )
    }

    fun mapVersionGameIndexDTOToVersionGameIndex(dto: VersionGameIndexDTO?): VersionGameIndex? {
        dto ?: return null
        return mapNamedApiResourceDTOToNamedApiResource(dto.version)?.let {
            VersionGameIndex(
                gameIndex = dto.game_index,
                version = it
            )
        }
    }

    fun mapHeldItemDTOToHeldItem(dto: PokemonHeldItemDTO?): HeldItem? {
        dto ?: return null
        return mapNamedApiResourceDTOToNamedApiResource(dto.item)?.let {
            HeldItem(
                item = it,
                versionDetails = dto.version_details?.mapNotNull { mapVersionDetailDTOToVersionDetail(it) } ?: emptyList()
            )
        }
    }
    fun mapVersionDetailDTOToVersionDetail(dto: PokemonHeldItemVersionDTO?): VersionDetail? {
        dto ?: return null
        return mapNamedApiResourceDTOToNamedApiResource(dto.version)?.let {
            VersionDetail(
                rarity = dto.rarity,
                version = it
            )
        }
    }

    fun mapMoveDTOToMove(dto: PokemonMoveDTO?): Move? {
        dto ?: return null
        return mapNamedApiResourceDTOToNamedApiResource(dto.move)?.let {
            Move(
                move = it,
                versionGroupDetails = dto.version_group_details?.mapNotNull { mapVersionGroupDetailDTOToVersionGroupDetail(it) } ?: emptyList()
            )
        }
    }

    fun mapVersionGroupDetailDTOToVersionGroupDetail(dto: PokemonMoveVersionDTO?): VersionGroupDetail? {
        dto ?: return null
        return mapNamedApiResourceDTOToNamedApiResource(dto.move_learn_method)?.let {
            mapNamedApiResourceDTOToNamedApiResource(dto.version_group)?.let { it1 ->
                VersionGroupDetail(
                    levelLearnedAt = dto.level_learned_at,
                    moveLearnMethod = it,
                    versionGroup = it1
                )
            }
        }
    }

    fun mapPokemonSpritesDTOToPokemonSprites(dto: PokemonSpritesDTO?): PokemonSprites? {
        dto ?: return null
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

    fun mapDreamWorldSpritesDTOToDreamWorldSprites(dto: DreamWorldSpritesDTO?): DreamWorldSprites? {
        dto ?: return null
        return DreamWorldSprites(
            frontDefault = dto.front_default,
            frontFemale = dto.front_female
        )
    }

    fun mapHomeSpritesDTOToHomeSprites(dto: HomeSpritesDTO?): HomeSprites? {
        dto ?: return null
        return HomeSprites(
            frontDefault = dto.front_default,
            frontFemale = dto.front_female,
            frontShiny = dto.front_shiny,
            frontShinyFemale = dto.front_shiny_female
        )
    }

    fun mapOfficialArtworkSpritesDTOToOfficialArtworkSprites(dto: OfficialArtworkSpritesDTO?): OfficialArtworkSprites? {
        dto ?: return null
        return OfficialArtworkSprites(
            frontDefault = dto.front_default,
            frontShiny = dto.front_shiny
        )
    }

    fun mapPokemonStatDTOToPokemonStat(dto: PokemonStatDTO?): PokemonStat? {
        dto ?: return null
        return mapNamedApiResourceDTOToNamedApiResource(dto.stat)?.let {
            PokemonStat(
                baseStat = dto.base_stat,
                effort = dto.effort,
                stat = it
            )
        }
    }

    fun mapPokemonTypeDTOToPokemonType(dto: PokemonTypeDTO?): PokemonType? {
        dto ?: return null
        return mapNamedApiResourceDTOToNamedApiResource(dto.type)?.let {
            PokemonType(
                slot = dto.slot,
                type = it
            )
        }
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

    fun mapRedBlueSpritesDTOToRedBlueSprites(dto: RedBlueSpritesDTO?): RedBlueSprites? {
        return dto?.let {
            RedBlueSprites(
                backDefault = it.back_default,
                backGray = it.back_gray,
                backTransparent = it.back_transparent,
                frontDefault = it.front_default,
                frontGray = it.front_gray,
                frontTransparent = it.front_transparent
            )
        }
    }

    fun mapYellowSpritesDTOToYellowSprites(dto: YellowSpritesDTO?): YellowSprites? {
        return dto?.let {
            YellowSprites(
                backDefault = it.back_default,
                backGray = it.back_gray,
                backTransparent = it.back_transparent,
                frontDefault = it.front_default,
                frontGray = it.front_gray,
                frontTransparent = it.front_transparent
            )
        }
    }

    fun mapGenerationIISpritesDTOToGenerationIISprites(dto: GenerationIISpritesDTO): GenerationIISprites {
        return GenerationIISprites(
            crystal = dto.crystal?.let { mapCrystalSpritesDTOToCrystalSprites(it) },
            gold = dto.gold?.let { mapGoldSilverSpritesDTOToGoldSilverSprites(it) },
            silver = dto.silver?.let { mapGoldSilverSpritesDTOToGoldSilverSprites(it) }
        )
    }

    fun mapCrystalSpritesDTOToCrystalSprites(dto: CrystalSpritesDTO?): CrystalSprites? {
        return dto?.let {
            CrystalSprites(
                backDefault = it.back_default,
                backShiny = it.back_shiny,
                backShinyTransparent = it.back_shiny_transparent,
                backTransparent = it.back_transparent,
                frontDefault = it.front_default,
                frontShiny = it.front_shiny,
                frontShinyTransparent = it.front_shiny_transparent,
                frontTransparent = it.front_transparent
            )
        }
    }

    fun mapGoldSilverSpritesDTOToGoldSilverSprites(dto: GoldSilverSpritesDTO?): GoldSilverSprites? {
        return dto?.let {
            GoldSilverSprites(
                backDefault = it.back_default,
                backShiny = it.back_shiny,
                frontDefault = it.front_default,
                frontShiny = it.front_shiny,
                frontTransparent = it.front_transparent
            )
        }
    }

    fun mapGenerationIIISpritesDTOToGenerationIIISprites(dto: GenerationIIISpritesDTO): GenerationIIISprites {
        return GenerationIIISprites(
            emerald = dto.emerald?.let { mapEmeraldSpritesDTOToEmeraldSprites(it) },
            fireredLeafgreen = dto.firered_leafgreen?.let { mapFireRedLeafGreenSpritesDTOToFireRedLeafGreenSprites(it) },
            rubySapphire = dto.ruby_sapphire?.let { mapRubySapphireSpritesDTOToRubySapphireSprites(it) }
        )
    }

    fun mapEmeraldSpritesDTOToEmeraldSprites(dto: EmeraldSpritesDTO?): EmeraldSprites? {
        return dto?.let {
            EmeraldSprites(
                frontDefault = it.front_default,
                frontShiny = it.front_shiny
            )
        }
    }
    fun mapFireRedLeafGreenSpritesDTOToFireRedLeafGreenSprites(dto: FireRedLeafGreenSpritesDTO?): FireRedLeafGreenSprites? {
        return dto?.let {
            FireRedLeafGreenSprites(
                backDefault = it.back_default,
                backShiny = it.back_shiny,
                frontDefault = it.front_default,
                frontShiny = it.front_shiny
            )
        }
    }

    fun mapRubySapphireSpritesDTOToRubySapphireSprites(dto: RubySapphireSpritesDTO?): RubySapphireSprites? {
        return dto?.let {
            RubySapphireSprites(
                backDefault = it.back_default,
                backShiny = it.back_shiny,
                frontDefault = it.front_default,
                frontShiny = it.front_shiny
            )
        }
    }

    fun mapGenerationIVSpritesDTOToGenerationIVSprites(dto: GenerationIVSpritesDTO): GenerationIVSprites {
        return GenerationIVSprites(
            diamondPearl = dto.diamond_pearl?.let { mapDiamondPearlSpritesDTOToDiamondPearlSprites(it) },
            heartgoldSoulsilver = dto.heartgold_soulsilver?.let { mapHeartGoldSoulSilverSpritesDTOToHeartGoldSoulSilverSprites(it) },
            platinum = dto.platinum?.let { mapPlatinumSpritesDTOToPlatinumSprites(it) }
        )
    }

    fun mapDiamondPearlSpritesDTOToDiamondPearlSprites(dto: DiamondPearlSpritesDTO?): DiamondPearlSprites? {
        return dto?.let {
            DiamondPearlSprites(
                backDefault = it.back_default,
                backFemale = it.back_female,
                backShiny = it.back_shiny,
                backShinyFemale = it.back_shiny_female,
                frontDefault = it.front_default,
                frontFemale = it.front_female,
                frontShiny = it.front_shiny,
                frontShinyFemale = it.front_shiny_female
            )
        }
    }

    fun mapHeartGoldSoulSilverSpritesDTOToHeartGoldSoulSilverSprites(dto: HeartGoldSoulSilverSpritesDTO?): HeartGoldSoulSilverSprites? {
        return dto?.let {
            HeartGoldSoulSilverSprites(
                backDefault = it.back_default,
                backFemale = it.back_female,
                backShiny = it.back_shiny,
                backShinyFemale = it.back_shiny_female,
                frontDefault = it.front_default,
                frontFemale = it.front_female,
                frontShiny = it.front_shiny,
                frontShinyFemale = it.front_shiny_female
            )
        }
    }

    fun mapPlatinumSpritesDTOToPlatinumSprites(dto: PlatinumSpritesDTO?): PlatinumSprites? {
        return dto?.let {
            PlatinumSprites(
                backDefault = it.back_default,
                backFemale = it.back_female,
                backShiny = it.back_shiny,
                backShinyFemale = it.back_shiny_female,
                frontDefault = it.front_default,
                frontFemale = it.front_female,
                frontShiny = it.front_shiny,
                frontShinyFemale = it.front_shiny_female
            )
        }
    }

    fun mapGenerationVSpritesDTOToGenerationVSprites(dto: GenerationVSpritesDTO): GenerationVSprites {
        return GenerationVSprites(
            blackWhite = dto.black_white?.let { mapBlackWhiteSpritesDTOToBlackWhiteSprites(it) }
        )
    }

    fun mapBlackWhiteSpritesDTOToBlackWhiteSprites(dto: BlackWhiteSpritesDTO?): BlackWhiteSprites? {
        return dto?.let {
            BlackWhiteSprites(
                animated = it.animated?.let { animDto -> mapAnimatedSpritesDTOToAnimatedSprites(animDto) },
                backDefault = it.back_default,
                backFemale = it.back_female,
                backShiny = it.back_shiny,
                backShinyFemale = it.back_shiny_female,
                frontDefault = it.front_default,
                frontFemale = it.front_female,
                frontShiny = it.front_shiny,
                frontShinyFemale = it.front_shiny_female
            )
        }
    }

    fun mapAnimatedSpritesDTOToAnimatedSprites(dto: AnimatedSpritesDTO?): AnimatedSprites? {
        return dto?.let {
            AnimatedSprites(
                backDefault = it.back_default,
                backFemale = it.back_female,
                backShiny = it.back_shiny,
                backShinyFemale = it.back_shiny_female,
                frontDefault = it.front_default,
                frontFemale = it.front_female,
                frontShiny = it.front_shiny,
                frontShinyFemale = it.front_shiny_female
            )
        }
    }

    fun mapGenerationVISpritesDTOToGenerationVISprites(dto: GenerationVISpritesDTO): GenerationVISprites {
        return GenerationVISprites(
            omegarubyAlphasapphire = dto.omegaruby_alphasapphire?.let { mapOmegarubyAlphasapphireSpritesDTOToOmegarubyAlphasapphireSprites(it) },
            xy = dto.x_y?.let { mapXYSpritesDTOToXYSprites(it) }
        )
    }

    fun mapOmegarubyAlphasapphireSpritesDTOToOmegarubyAlphasapphireSprites(dto: OmegarubyAlphasapphireSpritesDTO?): OmegarubyAlphasapphireSprites? {
        return dto?.let {
            OmegarubyAlphasapphireSprites(
                frontDefault = it.front_default,
                frontFemale = it.front_female,
                frontShiny = it.front_shiny,
                frontShinyFemale = it.front_shiny_female
            )
        }
    }

    fun mapXYSpritesDTOToXYSprites(dto: XYSpritesDTO?): XYSprites? {
        return dto?.let {
            XYSprites(
                frontDefault = it.front_default,
                frontFemale = it.front_female,
                frontShiny = it.front_shiny,
                frontShinyFemale = it.front_shiny_female
            )
        }
    }

    fun mapGenerationVIISpritesDTOToGenerationVIISprites(dto: GenerationVIISpritesDTO?): GenerationVIISprites? {
        return dto?.let {
            GenerationVIISprites(
                icons = it.icons?.let { iconsDto -> mapIconsSpritesDTOToIconsSprites(iconsDto) },
                ultraSunUltraMoon = it.ultra_sun_ultra_moon?.let { usumDto -> mapUltraSunUltraMoonSpritesDTOToUltraSunUltraMoonSprites(usumDto) }
            )
        }
    }

    fun mapIconsSpritesDTOToIconsSprites(dto: IconsSpritesDTO?): IconsSprites? {
        return dto?.let {
            IconsSprites(
                frontDefault = it.front_default,
                frontFemale = it.front_female
            )
        }
    }

    fun mapUltraSunUltraMoonSpritesDTOToUltraSunUltraMoonSprites(dto: UltraSunUltraMoonSpritesDTO?): UltraSunUltraMoonSprites? {
        return dto?.let {
            UltraSunUltraMoonSprites(
                frontDefault = it.front_default,
                frontFemale = it.front_female,
                frontShiny = it.front_shiny,
                frontShinyFemale = it.front_shiny_female
            )
        }
    }

    fun mapGenerationVIIISpritesDTOToGenerationVIIISprites(dto: GenerationVIIISpritesDTO?): GenerationVIIISprites? {
        return dto?.let {
            GenerationVIIISprites(
                icons = it.icons?.let { iconsDto -> mapIconsSpritesDTOToIconsSprites(iconsDto) }
            )
        }
    }

}