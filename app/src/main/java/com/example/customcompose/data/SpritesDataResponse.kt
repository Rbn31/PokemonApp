package com.example.customcompose.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SpritesDataResponse(
    @SerializedName("front_default")
    val frontDefault: String? = null,

    @SerializedName("back_default")
    val backDefault: String? = null,

    @SerializedName("front_shiny")
    val frontShiny: String? = null,

    @SerializedName("back_shiny")
    val backShiny: String? = null
): Serializable
