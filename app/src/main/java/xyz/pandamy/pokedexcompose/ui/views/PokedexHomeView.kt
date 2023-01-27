package xyz.pandamy.pokedexcompose.ui.views

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import xyz.pandamy.pokedexcompose.models.PokemonBase
import xyz.pandamy.pokedexcompose.models.PokemonList

@Composable
fun PokedexHomeView(list: List<PokemonBase>) {
    LazyColumn {
        items(list) {pokemon ->
            PokemonTile(pokemon, list)
        }
    }
}