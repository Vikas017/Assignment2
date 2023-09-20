package com.android.movie.screen.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.android.movie.repo.network.api.MovieApi
import com.android.movie.utils.MovieDetail
import kotlinx.coroutines.launch


class MovieDetailViewModel(private val movieApi: MovieApi,private val id: Int): ViewModel() {

    private val _movieDetail: MutableLiveData<MovieDetail> = MutableLiveData()
    val movieDetail: LiveData<MovieDetail> = _movieDetail

    init {
        fetchMoviedetails()
    }

    companion object {
        val TAG = "DetailViewModel"
    }

    private fun fetchMoviedetails() {
        viewModelScope.launch {
            try {
                _movieDetail.value = movieApi.fetchMovieDetail(id)
            } catch (e: Exception) {
                Log.e(TAG, "Error in detail fetching")
            }
        }
    }
}