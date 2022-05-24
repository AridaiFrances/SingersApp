package com.ari.singersapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ari.singersapp.domain.GetArtistByNameUseCase
import com.ari.singersapp.domain.GetArtistCollectionUseCase
import com.ari.singersapp.model.artist.ArtistInterface
import com.ari.singersapp.utils.NetworkAvailabilityHelper
import com.ari.singersapp.utils.Resource
import com.ari.singersapp.utils.RestWsKeys
import com.ari.singersapp.utils.Status
import kotlinx.coroutines.launch

class ArtistCollectionListViewModel(
    private val getArtistCollectionUseCase: GetArtistCollectionUseCase,
    private val getArtistByNameUseCase: GetArtistByNameUseCase,
    private val networkHelper: NetworkAvailabilityHelper
) : ViewModel() {

    private val _artists = MutableLiveData<Resource<ArtistInterface>>()
    val artists: LiveData<Resource<ArtistInterface>>
        get() = _artists


    fun fetchArtists() {
        viewModelScope.launch {
            _artists.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                getArtistCollectionUseCase.getTopArtistsList(
                    RestWsKeys.API_METHOD_POST_TOP_ARTISTS,
                    RestWsKeys.API_FORMAT_RESPONSE,
                    RestWsKeys.API_KEY
                ).let {
                    if (it.isSuccessful) {
                        _artists.postValue(Resource.success(it.body()))
                    } else _artists.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _artists.postValue(Resource.error("No internet connection", null))
        }
    }

    fun fetchArtistByName(artistName: String) {
        viewModelScope.launch {
            _artists.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                getArtistByNameUseCase.getArtistByName(
                    artistName,
                    RestWsKeys.API_METHOD_POST_TOP_ARTISTS,
                    RestWsKeys.API_FORMAT_RESPONSE,
                    RestWsKeys.API_KEY
                ).let {
                    if (it.isSuccessful) {
                        _artists.postValue(Resource.success(it.body()))
                    } else _artists.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _artists.postValue(Resource.error("No internet connection", null))
        }
    }
}