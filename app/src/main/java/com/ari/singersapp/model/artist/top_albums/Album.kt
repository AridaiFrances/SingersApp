package com.ari.singersapp.model.artist.top_albums

import com.ari.singersapp.model.artist.Artist
import com.ari.singersapp.model.artist.Image

data class Album(
    val artist: Artist,
    val image: List<Image>,
    val mbid: String,
    val name: String?,
    val playcount: Int,
    val url: String
)