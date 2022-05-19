package com.ari.singersapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ari.singersapp.domain.GetArtistInfoUseCase
import com.ari.singersapp.domain.GetArtistTopAlbumsUseCase
import com.ari.singersapp.model.artist.artist_info.ArtistInfoResponse
import com.ari.singersapp.model.artist.top_albums.ArtistTopAlbumsResponse
import com.ari.singersapp.utils.NetworkAvailabilityHelper
import com.ari.singersapp.utils.Resource
import com.ari.singersapp.utils.RestWsKeys
import kotlinx.coroutines.launch

class ArtistDetailViewModel(
    private val getArtistInfoUseCase: GetArtistInfoUseCase,
    private val getArtistTopAlbumsUseCase: GetArtistTopAlbumsUseCase,
    private val networkHelper: NetworkAvailabilityHelper
) : ViewModel() {

    private val _artistInfo = MutableLiveData<Resource<ArtistInfoResponse>>()
    val artistInfo: LiveData<Resource<ArtistInfoResponse>>
        get() = _artistInfo

    private val _artistAlbums = MutableLiveData<Resource<ArtistTopAlbumsResponse>>()
    val artistAlbums: LiveData<Resource<ArtistTopAlbumsResponse>>
        get() = _artistAlbums


    fun fetchArtistInfo(artistMbid: String) {
        viewModelScope.launch {
            _artistInfo.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                getArtistInfoUseCase.getArtistInfo(
                    artistMbid,
                    RestWsKeys.API_METHOD_POST_TOP_ARTISTS,
                    RestWsKeys.API_FORMAT_RESPONSE,
                    RestWsKeys.API_KEY
                ).let {
                    if (it.isSuccessful) {
                        _artistInfo.postValue(Resource.success(it.body()))
                    } else _artistInfo.postValue(
                        Resource.error(
                            it.errorBody().toString(),
                            null
                        )
                    )
                }
            } else _artistInfo.postValue(Resource.error("No internet connection", null))
        }
    }

    fun fetchArtistAlbums(artistMbid: String) {
        viewModelScope.launch {
            _artistAlbums.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                getArtistTopAlbumsUseCase.getArtistTopAlbums(
                    artistMbid,
                    RestWsKeys.API_METHOD_POST_TOP_ARTISTS,
                    RestWsKeys.API_FORMAT_RESPONSE,
                    RestWsKeys.API_KEY
                ).let {
                    if (it.isSuccessful) {
                        _artistAlbums.postValue(Resource.success(it.body()))
                    } else _artistAlbums.postValue(
                        Resource.error(
                            it.errorBody().toString(),
                            null
                        )
                    )
                }
            } else _artistAlbums.postValue(Resource.error("No internet connection", null))
        }
    }
}