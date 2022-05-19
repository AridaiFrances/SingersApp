package com.ari.singersapp.domain

import com.ari.singersapp.data.repository.MainRepository

class GetArtistCollectionUseCase(private val mainRepository: MainRepository) {

    /**
     * @param method api method
     * @param format needed to retrieve json or xml
     * @param apiKey personal apiKey access
     * @return Model with list of 50 most important artist from api
     */
    suspend fun getTopArtistsList(
        method: String,
        format: String,
        apiKey: String
    ) = mainRepository.getTopArtists(method, format, apiKey)
}