package com.android.movie.repo.network.api

import com.android.movie.utils.Movie
import com.android.movie.utils.MovieDetail
import com.android.movie.utils.MoviesList
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap
import retrofit2.http.QueryName

private const val API_KEY = "pSBiT7JGwfZlz2A0wSF4FfkNiOK7qkW4P4k9o5pC"

interface MovieApi {
    @GET("sources?apiKey=$API_KEY")
    suspend fun fetchSources(): List<Movie>

    @GET("list-titles?apiKey=$API_KEY")
    suspend fun fetchMovies(): MoviesList

    @GET("title/{title_id}/details?apiKey=$API_KEY")
    suspend fun fetchMovieDetail(@Path("title_id") id: Int): MovieDetail
}