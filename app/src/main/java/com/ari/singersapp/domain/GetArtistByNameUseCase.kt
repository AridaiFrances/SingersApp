package com.ari.singersapp.domain

import com.ari.singersapp.data.repository.MainRepository

class GetArtistByNameUseCase(private val mainRepository: MainRepository) {

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
    ) = mainRepository.getArtistByName(artistName, method, format, apiKey)
}