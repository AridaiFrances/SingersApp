package com.ari.singersapp.model.artist.search_by_name

import com.ari.singersapp.model.artist.ArtistInterface

data class ArtistByNameResponse(
    val results: Results
): ArtistInterface