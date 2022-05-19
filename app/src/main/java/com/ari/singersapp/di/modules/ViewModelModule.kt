package com.ari.singersapp.di.modules

import com.ari.singersapp.ui.viewmodel.ArtistCollectionListViewModel
import com.ari.singersapp.ui.viewmodel.ArtistDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        ArtistCollectionListViewModel()
    }

    viewModel {
        ArtistDetailViewModel()
    }

}