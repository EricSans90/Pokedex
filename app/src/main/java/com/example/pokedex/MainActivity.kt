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
                    PokedexApp()
                }
            }
        }
    }
}

@Composable
//@HiltAndroidApp
fun PokedexApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "pokemonList") {
        composable("pokemonList") {
            // inyectar el ViewModel
            PokemonListScreen(/* viewModel = ... */) { pokemonName ->
                navController.navigate("pokemonDetail/$pokemonName")
            }
        }
        composable("pokemonDetail/{pokemonName}") { backStackEntry ->
            val pokemonName = backStackEntry.arguments?.getString("pokemonName")
            // inyectar el ViewModel
            PokemonDetailScreen(/* viewModel = ... */)
        }
    }
}



