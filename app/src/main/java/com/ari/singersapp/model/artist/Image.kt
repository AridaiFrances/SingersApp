package com.ari.singersapp.model.artist

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("#text")
    val text: String?,
    val size: String?
)