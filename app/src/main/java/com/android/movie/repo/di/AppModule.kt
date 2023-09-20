package com.android.movie.repo.di

import com.android.movie.screen.viewmodel.MovieDetailViewModel
import com.android.movie.screen.viewmodel.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val APP_MODULE = module {
    viewModel { MovieViewModel(get()) } //movie viewmodel
}