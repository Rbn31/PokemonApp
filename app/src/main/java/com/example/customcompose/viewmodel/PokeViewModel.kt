package com.example.customcompose.viewmodel

import androidx.lifecycle.ViewModel
import com.example.customcompose.data.ListPokeDataResponse
import com.example.customcompose.state.PokeState
import com.example.customcompose.service.PokeRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokeViewModel : ViewModel() {

    private val _state: MutableStateFlow<PokeState?> = MutableStateFlow(PokeState.Loading)
    val state: StateFlow<PokeState?> get() = _state

    fun getPokemonList() {
        val api = PokeRequest.instance
        api.getPokemonListNames(151).enqueue(object : Callback<ListPokeDataResponse> {

            override fun onResponse(
                call: Call<ListPokeDataResponse>,
                response: Response<ListPokeDataResponse>
            ) {
                if (response.isSuccessful){
                    val listPokemon = response.body()?.results ?: emptyList()
                    _state.value = PokeState.SuccessGetListNames(listPokemon)
                }else{
                    _state.value = PokeState.Error("Erro: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ListPokeDataResponse>, t: Throwable) {
                _state.value = PokeState.Error("Houve uma Falha na requisição: ${t.message}")
            }
        })
    }
}