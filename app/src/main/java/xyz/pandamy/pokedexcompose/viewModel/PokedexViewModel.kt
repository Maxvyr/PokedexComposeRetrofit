package xyz.pandamy.pokedexcompose.viewModel

import androidx.lifecycle.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch
import retrofit2.HttpException
import xyz.pandamy.pokedexcompose.dataServices.PokedexAPI
import xyz.pandamy.pokedexcompose.models.PokemonList
import xyz.pandamy.pokedexcompose.ui.uiState.PokedexUiState
import java.io.IOException

class PokedexViewModel : ViewModel() {
    var pokemonlistState : PokedexUiState by mutableStateOf(PokedexUiState.LOADING)

    fun getList() {
        println("Get List")
        viewModelScope.launch {
            pokemonlistState = try {
                val res = PokedexAPI.service.getPokemonList()
                PokedexUiState.SUCCESS(list = jsonToItem(res))
            } catch (io: IOException) {
                println("IOException ->${io.message}")
                PokedexUiState.ERROR(io.message?:"")
            } catch (http: HttpException) {
                println("HttpException ->${http.code()}")
                println("HttpException ->${http.message}")
                println("HttpException ->${http.localizedMessage}")
                println("HttpException ->${http.message()}")
                PokedexUiState.ERROR(http.message?:"")
            }
        }
    }

    fun jsonToItem(json: String) : PokemonList {
        val gson = Gson()
        val type = object : TypeToken<PokemonList>() {}.type
        return  gson.fromJson(json,type)
    }
}