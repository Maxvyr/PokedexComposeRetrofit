package xyz.pandamy.pokedexcompose.ui.uiState

import xyz.pandamy.pokedexcompose.models.PokemonList

interface PokedexUiState {
    object LOADING : PokedexUiState
    data class ERROR(val error: String) : PokedexUiState
    data class SUCCESS(val list: PokemonList) : PokedexUiState
}