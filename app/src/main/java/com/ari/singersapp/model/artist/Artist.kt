package com.ari.singersapp.model.artist

import com.ari.singersapp.model.artist.artist_info.Bio

data class Artist(
    val bio: Bio?,
    val image: List<Image>,
    val mbid: String?,
    val name: String?,
    val url: String?,
    val summary: String?,
    val playcount: String?
)
