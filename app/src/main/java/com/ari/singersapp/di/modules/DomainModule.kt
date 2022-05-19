package com.ari.singersapp.di.modules

import com.ari.singersapp.domain.GetArtistByNameUseCase
import com.ari.singersapp.domain.GetArtistCollectionUseCase
import com.ari.singersapp.domain.GetArtistInfoUseCase
import com.ari.singersapp.domain.GetArtistTopAlbumsUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetArtistCollectionUseCase(get())

    }

    factory {
        GetArtistByNameUseCase(get())
    }

    factory {
        GetArtistInfoUseCase(get())
    }

    factory {
        GetArtistTopAlbumsUseCase(get())
    }
}