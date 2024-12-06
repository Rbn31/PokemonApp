package com.example.customcompose.repository

import com.example.customcompose.data.ListPokeDataResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApiRepository {

    @GET("pokemon")
    fun getPokemonListNames(

        @Query("limit")
        limit: Int

    ): Call<ListPokeDataResponse>
}