package com.ari.singersapp.model.artist

data class Artist(
    val image: List<Image>,
    val mbid: String?,
    val name: String,
    val playcount: String?,
    val url: String,
    val summary: String?
)