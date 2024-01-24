package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.ui.screens.PokemonDetailScreen
import com.example.pokedex.ui.screens.PokemonListScreen
import com.example.pokedex.ui.theme.PokedexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PokedexNavigation()
                }
            }
        }
    }
}


@Composable
fun PokedexNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "pokemonList") {
        composable("pokemonList") {
            PokemonListScreen(onPokemonSelected = { pokemonName ->
                navController.navigate("pokemonDetail/$pokemonName")
            })
        }
        composable("pokemonDetail/{pokemonName}") { backStackEntry ->
            PokemonDetailScreen(
                pokemonName = backStackEntry.arguments?.getString("pokemonName") ?: "",
                navController = navController
            )
        }
    }
}




