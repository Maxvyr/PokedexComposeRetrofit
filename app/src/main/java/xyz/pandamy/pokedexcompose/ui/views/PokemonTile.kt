package xyz.pandamy.pokedexcompose.ui.views


import android.util.Log
import androidx.compose.foundation.layout.*
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


@Composable
fun PokemonTile(pokemon: PokemonBase, list: List<PokemonBase>) {
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


    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
//            .clickable {
//                onClick(pokemon)
//            }
    ) {
        Text(text = pokemon.name)
        AsyncImage(
            model = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/${position}.png",
            contentDescription = "image de ${pokemon.name}",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .padding(8.dp)
                .clip(MaterialTheme.shapes.large),
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground), //temporary
        )
    }
}