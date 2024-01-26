package com.example.pokedex.ui.components

//Para mostrar el detalle de un Pokémon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.pokedex.R
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonType
import com.example.pokedex.ui.theme.PokemonTypeColors
import com.example.pokedex.ui.theme.StatATK
import com.example.pokedex.ui.theme.StatDEF
import com.example.pokedex.ui.theme.StatHP
import com.example.pokedex.ui.theme.StatSATK
import com.example.pokedex.ui.theme.StatSDEF
import com.example.pokedex.ui.theme.StatSPD
import com.example.pokedex.ui.theme.backDetail
import com.example.pokedex.ui.theme.backGr

@Composable
fun PokemonDetailView(pokemon: Pokemon, navController: NavController) {
    // UI para mostrar el detalle de un Pokemon
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = backGr)
        //.padding(12.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 36.dp, bottomEnd = 36.dp),
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = backDetail)
        ) {

            Column() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Row() {
                        IconButton(onClick = {navController.navigate("pokemonList") }) {
                            Icon(
                                Icons.Default.ArrowBack,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                        Text(
                            text = "Pokedex",
                            color = Color.White,
                            modifier = Modifier.padding(top = 10.dp)

                        )
                    }
                    Text(
                        text = "#${pokemon.id}",
                        color = Color.White,
                        modifier = Modifier.padding(top = 10.dp, end = 10.dp)

                    )
                }

                ImageLoader(
                    // SUpongo que frontDefault está siempre
                    // y sino pongo una imagen por defecto en el placeholder
                    imageUrl = pokemon.sprites.frontDefault,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,){
            Text(text = "${pokemon.name}",
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.pokemonhollow)),
                fontSize = 45.sp
            )
        }
        Spacer(modifier = Modifier.height(0.dp))
        if(pokemon.types.size ==1){
            TypeChips(types = listOf(pokemon.types.first()))
        } else if (pokemon.types.size > 1){
            TypeChips(types = pokemon.types)
        }

        //Text(text = "Types: ${pokemon.types.joinToString { it.type.name }}", color = Color.White)
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            ){
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = "${pokemon.weight} KG",
                    color = Color.White,
                    fontSize = 30.sp)
                Text(text = "Weight",
                    color = Color.Gray)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(){
                Text(text = "${pokemon.height} M",
                    color = Color.White,
                    fontSize = 30.sp)
                Text(text = "Height",
                    color = Color.Gray)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Base Stats",
            color = Color.White,
            fontSize = 25.sp)
        Column (verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            pokemon.stats.forEach { stat ->
                Text(text = "${getStatName(stat.stat.name)}: ${stat.baseStat}",
                    color = Color.White)

                //Spacer(modifier = Modifier.height(8.dp))
                //Aunque en el pokemon cada pokemon tiene unos stats máximos diferentes,
                // nosotros trabajaremos con 255 de número teórico, pero dependen de cada
                // pokemon individual, no todos pueden llegar a 255
                val MAX_STAT_VALUE = 255
                LinearProgressIndicator(progress = stat.baseStat.toFloat() / MAX_STAT_VALUE,
                    modifier=Modifier.heightIn(12.dp)
                        .clip(RoundedCornerShape(50)),
                    color = getStatColor(stat.stat.name)
                )
            }
        }
    }
}

@Composable
fun ChipView(typeName: String) {
    val chipColor = PokemonTypeColors[typeName.toLowerCase()] ?: Color.Gray
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(50),
        modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(50)),
        colors = CardDefaults.cardColors(containerColor = chipColor)
    ) {
        Text(
            text = typeName,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            color = Color.White
        )
    }
}


@Composable
fun TypeChips(types: List<PokemonType>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        types.forEach { type ->
            ChipView(typeName = type.type.name)
        }
    }
}

fun getStatColor(statName: String): Color{
    return when (statName){
        "hp" -> StatHP
        "attack" -> StatATK
        "defense" -> StatDEF
        "special-attack" -> StatSATK
        "special-defense" -> StatSDEF
        "speed" -> StatSPD
        else -> Color.Gray
    }
}

@Composable
fun getStatName(statName: String): String{
    return when (statName){
        "hp" -> "HP"
        "attack" -> "ATK"
        "defense" -> "DEF"
        "special-attack" -> "S-ATK"
        "special-defense" -> "S-DEF"
        "speed" -> "SPD"
        else -> "Stat"
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

