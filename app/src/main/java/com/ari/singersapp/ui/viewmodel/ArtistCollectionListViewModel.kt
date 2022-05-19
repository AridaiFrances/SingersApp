package com.ari.singersapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.ari.singersapp.domain.GetArtistByNameUseCase
import com.ari.singersapp.domain.GetArtistCollectionUseCase
import com.ari.singersapp.utils.NetworkAvailabilityHelper

class ArtistCollectionListViewModel(
    private val getArtistCollectionUseCase: GetArtistCollectionUseCase,
    private val getArtistByNameUseCase: GetArtistByNameUseCase,
    private val networkHelper: NetworkAvailabilityHelper
) : ViewModel() {
}