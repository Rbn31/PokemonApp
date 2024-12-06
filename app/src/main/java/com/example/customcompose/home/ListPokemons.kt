package com.example.customcompose.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.customcompose.data.PokeDataResponse

@Composable
fun ShowListPokemons(
    pokemonList: List<PokeDataResponse>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(pokemonList) { pokemon ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
//                AsyncImage(
//                    model = pokemon.url,
//                    contentDescription = "Pokemon Image",
//                    modifier = Modifier
//                        .size(100.dp)
//                        .align(Alignment.CenterHorizontally),
//                    contentScale = ContentScale.Fit
//                )

                Text(
                    text = "Name: ${pokemon.name}",
                    style = TextStyle(fontSize = 18.sp, color = Color.Black),
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }
}