package com.ari.singersapp.model.artist

import com.google.gson.annotations.SerializedName

data class Artists(
    @SerializedName("artist")
    val artistList: ArrayList<Artist>
)