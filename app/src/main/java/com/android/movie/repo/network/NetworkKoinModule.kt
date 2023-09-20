package com.android.movie.repo.network

import com.android.movie.repo.network.api.MovieApi
import org.koin.dsl.module

val NETWORK_MODULE = module {
    single { RetrofitProvider.create(MovieApi::class.java) }
}