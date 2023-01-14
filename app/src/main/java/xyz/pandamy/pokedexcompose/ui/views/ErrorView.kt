package xyz.pandamy.pokedexcompose.ui.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import xyz.pandamy.pokedexcompose.ui.theme.PokedexComposeTheme

@Composable
fun ErrorView(error: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Error : $error")
    }
}

@Preview(showBackground = true)
@Composable
private fun ErrorViewPreview() {
    PokedexComposeTheme {
        ErrorView(error = "ERROR")
    }
}