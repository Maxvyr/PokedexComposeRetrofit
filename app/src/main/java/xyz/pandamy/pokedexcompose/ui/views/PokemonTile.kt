package xyz.pandamy.pokedexcompose.ui.views


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import xyz.pandamy.pokedexcompose.R
import xyz.pandamy.pokedexcompose.models.PokemonBase
import java.util.*


@Composable
fun PokemonTile(pokemon: PokemonBase, list: List<PokemonBase>) {
    var name = pokemon.name.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
    }
    var position = ""
    for (pok in list) {
        if(pok.name == pokemon.name) {
            val index = list.lastIndexOf(pok) + 1
            position = when(index) {
                in 0..9 -> "00$index"
                in 9..99 -> "0$index"
                else -> "$index"
            }
        }
    }

    Card(
        elevation = 8.dp,
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .padding(10.dp)
            .clickable {
    //          onClick(pokemon)
                println(pokemon)
            }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(text = name, style = MaterialTheme.typography.h4)
            AsyncImage(
                model = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/${position}.png",
                contentDescription = "image de $name",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(120.dp)
                    .height(120.dp)
                    .padding(8.dp)
                    .clip(MaterialTheme.shapes.large),
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground), //temporary
            )
        }
    }
}