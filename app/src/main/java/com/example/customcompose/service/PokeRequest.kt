package com.example.customcompose.service

import com.example.customcompose.repository.PokeApiRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokeRequest {

    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    val instance: PokeApiRepository by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeApiRepository::class.java)
    }

}