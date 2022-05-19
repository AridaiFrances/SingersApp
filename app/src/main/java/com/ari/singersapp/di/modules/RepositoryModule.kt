package com.ari.singersapp.di.modules

import com.ari.singersapp.data.repository.MainRepository
import org.koin.dsl.module

val repoModule = module {
    single {
        MainRepository(get())
    }
}