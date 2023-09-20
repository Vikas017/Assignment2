package com.android.movie.screen.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.movie.repo.network.api.MovieApi
import com.android.movie.utils.Movie
import com.android.movie.utils.MovieDetail
import com.android.movie.utils.Status
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import retrofit2.HttpException

class MovieViewModel(private val movieApi: MovieApi): ViewModel() { //this will automatically injected by koin

    private val _movieList: MutableLiveData<List<Movie>> = MutableLiveData()
    val movieList: LiveData<List<Movie>> = _movieList
    private val _status: MutableLiveData<Status> = MutableLiveData()
    val status: LiveData<Status> = _status



    private val _movieDetail: MutableLiveData<MovieDetail> = MutableLiveData()
    val movieDetail: LiveData<MovieDetail> = _movieDetail

    companion object {
        private val TAG = "viewModel"
    }

    init {
        //fetch movie either from the server or local database
        //fetchMovieSource()
    }

    fun fetchSource() {
        fetchMovieSource()
    }

    private fun fetchMovieSource() {
        viewModelScope.launch {
            _status.value = Status.LOADING
            try {
                val list = movieApi.fetchMovies()
                _movieList.value = list.titles
                _status.value = Status.SUCCESS
                Log.i(TAG, "Movies List Fetch, size is : ${_movieList.value?.size}")
            } catch(e: HttpException) {
                _status.value = Status.ERROR
                Log.e(TAG, "Http Exception")
            } catch (e: Exception) {
                _status.value = Status.ERROR
                Log.e(TAG, "Exception: $e")
            }
        }
    }

    fun getMovieDetails(id: Int) {
        fetchMoviedetails(id)
    }

    private fun fetchMoviedetails(id: Int) {
        viewModelScope.launch {
            try {
                _movieDetail.value = movieApi.fetchMovieDetail(id)
                Log.i(TAG, "detail fetch; ${_movieDetail.value}")
            } catch (e: Exception) {
                Log.e(TAG, "Error in detail fetching")
            }
        }
    }

}