package com.ari.singersapp.model.artist

import com.google.gson.annotations.SerializedName

data class ArtistCollectionResponse(
    @SerializedName("artists")
    val artistsCollection: Artists
): ArtistInterface