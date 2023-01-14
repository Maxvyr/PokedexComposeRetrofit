package xyz.pandamy.pokedexcompose.models

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: String,
    val results : List<PokemonBase>
)

data class PokemonBase (
    val name: String,
    val url: String,
)