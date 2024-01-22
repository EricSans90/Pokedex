package com.example.pokedex.ui.components

//Para mostrar el detalle de un Pokémon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.pokedex.R
import com.example.pokedex.domain.models.Pokemon

@Composable
fun PokemonDetailView(pokemon: Pokemon) {
    // UI para mostrar el detalle de un Pokemon
    Column(){
        //Mostramos primer sprite disponible
        ImageLoader(
            imageUrl = pokemon.sprites.frontDefault,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Name: ${pokemon.name}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Types: ${pokemon.types.joinToString { it.type.name }}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Weight: ${pokemon.weight}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Height: ${pokemon.height}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Base Stats:")
        LazyRow {
            items(pokemon.stats) { stat ->
                Text(text = "${stat.stat.name}: ${stat.baseStat}")
            }
        }

    }

}

@Composable
fun ImageLoader(imageUrl: String?, modifier: Modifier = Modifier, contentScale: ContentScale = ContentScale.Fit) {
    val painter = if (!imageUrl.isNullOrEmpty()) {
        rememberImagePainter(
            data = imageUrl,
            builder = {
                placeholder(R.drawable.placeholder)
                error(R.drawable.error)
            }
        )
    } else {
        painterResource(R.drawable.placeholder)
    }

    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier,
        contentScale = contentScale
    )
}

