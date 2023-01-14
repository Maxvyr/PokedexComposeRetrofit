package xyz.pandamy.pokedexcompose.dataServices

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://pokeapi.co/api/v2/pokemon?limit=151
//base url
private const val baseUrl = "https://pokeapi.co/api/v2/"

//param refrofit
private  var scalarsConverterFactory = ScalarsConverterFactory.create()

//build retrofit
private  val retrofit = Retrofit
    .Builder()
    .addConverterFactory(scalarsConverterFactory)
    .baseUrl(baseUrl)
    .build()

interface PokedexService {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 151,
    ) : String
}

object  PokedexAPI {
    val service : PokedexService by lazy {
        retrofit.create(PokedexService::class.java)
    }
}