package com.ari.singersapp.data.remote

import com.ari.singersapp.model.artist.ArtistCollectionResponse
import com.ari.singersapp.model.artist.artist_info.ArtistInfoResponse
import com.ari.singersapp.model.artist.search_by_name.ArtistByNameResponse
import com.ari.singersapp.model.artist.top_albums.ArtistTopAlbumsResponse
import retrofit2.Response

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getTopArtists(
        method: String,
        format: String,
        apiKey: String
    ): Response<ArtistCollectionResponse> = apiService.getTopArtists(method, format, apiKey)

    override suspend fun getArtistByName(
        artistName: String,
        method: String,
        format: String,
        apiKey: String
    ): Response<ArtistByNameResponse> =
        apiService.getArtistByName(artistName, method, format, apiKey)

    override suspend fun getArtistInfo(
        artistMbid: String,
        method: String,
        format: String,
        apiKey: String
    ): Response<ArtistInfoResponse> = apiService.getArtistInfo(artistMbid, method, format, apiKey)

    override suspend fun getArtistTopAlbums(
        artistMbid: String,
        method: String,
        format: String,
        apiKey: String
    ): Response<ArtistTopAlbumsResponse> =
        apiService.getArtistTopAlbums(artistMbid, method, format, apiKey)
}