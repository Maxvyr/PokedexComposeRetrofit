package xyz.pandamy.pokedexcompose.ui.views

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun AppBar() {
    TopAppBar(title = { Text(text = "Pokedex")})
}