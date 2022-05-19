package com.ari.singersapp.domain

import com.ari.singersapp.data.repository.MainRepository

class GetArtistTopAlbumsUseCase(private val mainRepository: MainRepository) {

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
    ) = mainRepository.getArtistTopAlbums(artistMbid, method, format, apiKey)
}