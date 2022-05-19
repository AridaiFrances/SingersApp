package com.ari.singersapp.domain

import com.ari.singersapp.data.repository.MainRepository

class GetArtistInfoUseCase(private val mainRepository: MainRepository) {

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
    ) = mainRepository.getArtistInfo(artistMbid, method, format, apiKey)
}