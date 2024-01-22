package com.example.pokedex.di

import com.example.pokedex.data.repositories.PokemonRepositoryImpl
import com.example.pokedex.domain.repositories.PokemonRepository
import dagger.Binds
import dagger.Module
import android.content.Context
import com.example.pokedex.data.mappers.PokemonDataMapper
import com.example.pokedex.data.sources.remote.PokemonApiService
import com.example.pokedex.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedex.domain.usecases.GetPokemonDetailUseCase
import com.example.pokedex.domain.usecases.GetPokemonListUseCase
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
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
    fun provideGetPokemonDetailUseCase(pokemonRepository: PokemonRepository): GetPokemonDetailUseCase {
        return GetPokemonDetailUseCase(pokemonRepository)
    }
    @Provides
    fun providePokemonApiService(): PokemonApiService {
        return PokemonApiService.create()
    }

    @Provides
    fun providePokemonRemoteDataSource(apiService: PokemonApiService): PokemonRemoteDataSource {
        return PokemonRemoteDataSource(apiService)
    }

    @Provides
    fun providePokemonDataMapper(): PokemonDataMapper {
        return PokemonDataMapper()
    }

    @Provides
    fun provideContext(@ApplicationContext appContext: Context): Context {
        return appContext
    }
}

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {
    @Provides
    fun provideGetPokemonListUseCase(
        @ApplicationContext context: Context,
        pokemonRepository: PokemonRepository
    ): GetPokemonListUseCase {
        return GetPokemonListUseCase(context, pokemonRepository)
    }
}