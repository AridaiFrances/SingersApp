package com.ari.singersapp.data.remote

import com.ari.singersapp.model.artist.ArtistCollectionResponse
import com.ari.singersapp.model.artist.artist_info.ArtistInfoResponse
import com.ari.singersapp.model.artist.search_by_name.ArtistByNameResponse
import com.ari.singersapp.model.artist.top_albums.ArtistTopAlbumsResponse
import com.ari.singersapp.utils.RestWsKeys
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Network calls tested with insomnia software for the correct mounting of the url + endpoint
 */
interface ApiService {
    /**
     * Test call: http://ws.audioscrobbler.com/2.0/?method=chart.gettopartists&api_key=YOUR_API_KEY&format=json
     * API Documentation: https://www.last.fm/api/show/chart.getTopArtists
     */
    @POST(RestWsKeys.API_METHOD_POST_TOP_ARTISTS)
    @FormUrlEncoded
    suspend fun getTopArtists(
        @Field("method") method: String,
        @Field("format") format: String,
        @Field("api_key") apiKey: String
    ): Response<ArtistCollectionResponse>

    /**
     * Test call: http://ws.audioscrobbler.com/2.0/?method=artist.search&artist=cher&api_key=YOUR_API_KEY&format=json
     * API Documentation: https://www.last.fm/api/show/artist.search
     */
    @POST(RestWsKeys.API_METHOD_POST_ARTIST_SEARCH)
    @FormUrlEncoded
    suspend fun getArtistByName(
        @Field("artist") artistName: String,
        @Field("method") method: String,
        @Field("format") format: String,
        @Field("api_key") apiKey: String
    ): Response<ArtistByNameResponse>

    /**
     * Test call: http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist=Cher&api_key=YOUR_API_KEY&format=json
     * API Documentation: https://www.last.fm/api/show/artist.getInfo
     */
    @POST(RestWsKeys.API_METHOD_POST_ARTIST_INFO)
    @FormUrlEncoded
    suspend fun getArtistInfo(
        @Field("mbid") artistMbid: String,
        @Field("method") method: String,
        @Field("format") format: String,
        @Field("api_key") apiKey: String
    ): Response<ArtistInfoResponse>

    /**
     * Test call: http://ws.audioscrobbler.com/2.0/?method=artist.gettopalbums&artist=cher&api_key=YOUR_API_KEY&format=json
     * API Documentation: https://www.last.fm/api/show/artist.getTopAlbums
     */
    @POST(RestWsKeys.API_METHOD_POST_ARTIST_TOP_ALBUMS)
    @FormUrlEncoded
    suspend fun getArtistTopAlbums(
        @Field("mbid") artistMbid: String,
        @Field("method") method: String,
        @Field("format") format: String,
        @Field("api_key") apiKey: String
    ): Response<ArtistTopAlbumsResponse>
}