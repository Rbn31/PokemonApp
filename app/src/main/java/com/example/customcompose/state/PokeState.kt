package com.example.customcompose.state

import com.example.customcompose.data.ListPokeDataResponse
import com.example.customcompose.data.PokeDataResponse
import com.example.customcompose.data.SpritesDataResponse

sealed class PokeState {
    object Loading : PokeState()
    data class SuccessGetListNames(val pokelistNames: List<PokeDataResponse>): PokeState()
    data class Error(val message: String): PokeState()
}