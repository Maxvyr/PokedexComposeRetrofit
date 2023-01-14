package xyz.pandamy.pokedexcompose.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import xyz.pandamy.pokedexcompose.ui.uiState.PokedexUiState
import xyz.pandamy.pokedexcompose.viewModel.PokedexViewModel

@Composable
fun AppContent(modifier: Modifier, vm: PokedexViewModel = viewModel()) {
    val focusManager = LocalFocusManager.current
    vm.getList()
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        when (vm.pokemonlistState) {
            is PokedexUiState.LOADING -> LoadingView()
            is PokedexUiState.ERROR -> ErrorView(error = (vm.pokemonlistState as PokedexUiState.ERROR).error)
            is PokedexUiState.SUCCESS -> PokedexHomeView(list = (vm.pokemonlistState as PokedexUiState.SUCCESS).list.results)
        }
    }
}