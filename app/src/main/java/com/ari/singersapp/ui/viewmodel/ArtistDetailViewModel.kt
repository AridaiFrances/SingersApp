package com.ari.singersapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.ari.singersapp.domain.GetArtistInfoUseCase
import com.ari.singersapp.domain.GetArtistTopAlbumsUseCase
import com.ari.singersapp.utils.NetworkAvailabilityHelper

class ArtistDetailViewModel(
    private val getArtistInfoUseCase: GetArtistInfoUseCase,
    private val getArtistTopAlbumsUseCase: GetArtistTopAlbumsUseCase,
    private val networkHelper: NetworkAvailabilityHelper
) : ViewModel() {
}