package com.example.customcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.customcompose.ui.theme.res.CustomComposeTheme
import com.example.customcompose.components.CustomToolbar
import com.example.customcompose.data.PokeDataResponse
import com.example.customcompose.home.ShowListPokemons
import com.example.customcompose.state.PokeState
import com.example.customcompose.viewmodel.PokeViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private var viewModel = PokeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewModel.getPokemonList()
        setupObserver()
    }

    private fun setupObserver(){
        lifecycleScope.launch {
            viewModel.state.collect{ state ->
                when(state){
                    is PokeState.Loading -> {
                        Log.d("State", "Carregando dados...")
                    }
                    is PokeState.SuccessGetListNames -> {
                        setContent {
                            Column(modifier = Modifier.fillMaxSize()) {
                                ToolbarPreview()
                                ShowListPokemons(state.pokelistNames)
                            }
                        }
                    }
                    is PokeState.Error -> {
                        Log.e("API Error", state.message)
                    }
                    null ->{
                        Log.w("State", "Estado Inesperado: null")
                    }
                }
            }
        }
    }

}


@Composable
fun ToolbarPreview(){
    CustomToolbar(
        leftImage = painterResource(id = R.drawable.pokemon_logo),
        rightImage = painterResource(id = R.drawable.ic_back),
        title = "Meu Título",

    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CustomComposeTheme {
        Greeting("Android")
    }
}