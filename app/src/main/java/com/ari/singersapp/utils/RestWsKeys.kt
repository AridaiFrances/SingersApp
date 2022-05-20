package com.ari.singersapp.utils

class RestWsKeys {
    companion object {
        const val API_METHOD_POST_TOP_ARTISTS = "?method=chart.gettopartists"
        const val API_METHOD_POST_ARTIST_SEARCH = "?method=artist.search"
        const val API_METHOD_POST_ARTIST_INFO = "?method=artist.getinfo"
        const val API_METHOD_POST_ARTIST_TOP_ALBUMS = "?method=artist.gettopalbums"
        const val API_KEY = "'****"
        const val API_FORMAT_RESPONSE = "json"
    }
}