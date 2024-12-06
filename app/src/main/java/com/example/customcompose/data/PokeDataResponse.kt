package com.example.customcompose.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PokeDataResponse(
    @SerializedName("name")
    val name: String? = null,

    @SerializedName("url")
    val url: String? = null
) : Serializable

data class ListPokeDataResponse(
    @SerializedName("results")
    val results: List<PokeDataResponse>
): Serializable


