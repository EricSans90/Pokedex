package com.example.pokedex.di

import com.example.pokedex.data.repositories.PokemonRepositoryImpl
import com.example.pokedex.domain.repositories.PokemonRepository
import dagger.Binds
import dagger.Module
import android.content.Context
import com.example.pokedex.data.mappers.PokemonDataMapper
import com.example.pokedex.data.sources.remote.PokemonApiService
import com.example.pokedex.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedex.domain.usecases.GetPokemonListUseCase
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindingModule {
    @Binds
    abstract fun bindPokemonRepository(
        pokemonRepositoryImpl: PokemonRepositoryImpl
    ): PokemonRepository
}


@Module
@InstallIn(SingletonComponent::class)
object ProvidingModule {
    @Provides
    fun provideGetPokemonListUseCase(pokemonRepository: PokemonRepository): GetPokemonListUseCase {
        return GetPokemonListUseCase(pokemonRepository)
    }
    @Provides
    fun providePokemonApiService(@ApplicationContext context: Context): PokemonApiService {
        return PokemonApiService(context)
    }

    @Provides
    fun providePokemonRemoteDataSource(apiService: PokemonApiService): PokemonRemoteDataSource {
        return PokemonRemoteDataSource(apiService)
    }

    @Provides
    fun providePokemonDataMapper(): PokemonDataMapper {
        return PokemonDataMapper()
    }
}