package com.ari.singersapp.data.remote

import com.ari.singersapp.model.artist.ArtistCollectionResponse
import com.ari.singersapp.model.artist.artist_info.ArtistInfoResponse
import com.ari.singersapp.model.artist.search_by_name.ArtistByNameResponse
import com.ari.singersapp.model.artist.top_albums.ArtistTopAlbumsResponse
import retrofit2.Response

interface ApiHelper {

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
    ): Response<ArtistCollectionResponse>

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
    ): Response<ArtistByNameResponse>

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
    ): Response<ArtistInfoResponse>

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
    ): Response<ArtistTopAlbumsResponse>
}