package com.ari.singersapp.data.repository

import com.ari.singersapp.data.remote.ApiHelper
import com.ari.singersapp.model.artist.artist_info.ArtistInfoResponse
import com.ari.singersapp.model.artist.search_by_name.ArtistByNameResponse
import com.ari.singersapp.model.artist.top_albums.ArtistTopAlbumsResponse
import retrofit2.Response

class MainRepository(private val apiHelper: ApiHelper) {

    /**
     * @param method api method
     * @param format needed to retrieve json or xml
     * @param apiKey personal apiKey access
     * @return Model with list of 50 most important artist from api
     */
    suspend fun getTopArtists(
        method: String,
        format: String,
        apiKey: String
    ) = apiHelper.getTopArtists(method, format, apiKey)

    /**
     * @param artistName name of the artist to search
     * @param method api method
     * @param format needed to retrieve json or xml
     * @param apiKey personal apiKey access
     * @return List of artists whose name matches the search value
     */
    suspend fun getArtistByName(
        artistName: String,
        method: String,
        format: String,
        apiKey: String
    ): Response<ArtistByNameResponse> =
        apiHelper.getArtistByName(artistName, method, format, apiKey)

    /**
     * @param artistMbid artist mbid obtained from getTopArtists method
     * @param method api method
     * @param format needed to retrieve json or xml
     * @param apiKey personal apiKey access
     * @return Info about an specific artist
     */
    suspend fun getArtistInfo(
        artistMbid: String,
        method: String,
        format: String,
        apiKey: String
    ): Response<ArtistInfoResponse> = apiHelper.getArtistInfo(artistMbid, method, format, apiKey)

    /**
     * @param artistMbid artist mbid obtained from getTopArtists method
     * @param method api method
     * @param format needed to retrieve json or xml
     * @param apiKey personal apiKey access
     * @return list of the artist's best albums
     */
    suspend fun getArtistTopAlbums(
        artistMbid: String,
        method: String,
        format: String,
        apiKey: String
    ): Response<ArtistTopAlbumsResponse> =
        apiHelper.getArtistTopAlbums(artistMbid, method, format, apiKey)
}