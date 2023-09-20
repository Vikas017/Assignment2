package com.android.movie.utils

import com.squareup.moshi.Json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/*
{
    "id": 203,
    "name": "Netflix",
    "type": "sub",
    "logo_100px": "https://cdn.watchmode.com/provider_logos/netflix_100px.png",
    "ios_appstore_url": "http://itunes.apple.com/app/netflix/id363590051",
    "android_playstore_url": "https://play.google.com/store/apps/details?id=com.netflix.mediaclient&amp;hl=en",
    "android_scheme": "nflx",
    "ios_scheme": "nflx",
    "regions": ["US", "CA", "GB", "AU"]
}
 */
data class MoviesList(
    val titles: List<Movie>,
    val page: Int,
    val total_results: Int,
    val total_pages: Int
)

data class Movie(
    val id: Int,
    val title: String?,
    val year: String?,
    val imdb_id: String?,
    val tmdb_id: Int?,
    val imdb_type: String?,
    val type: String?

//    @Json(name = "logo_100px") val logo: String?,
//    @Json(name = "ios_appstore_url") val appStoreUrl: String?,
//    @Json(name = "android_playstore_url") val playstoreUrl: String?,
//    @Json(name = "android_scheme") val androidScheme: String?,
//    @Json(name = "ios_scheme") val iosScheme: String?,
//    val regions: List<String>?
)

data class MovieDetail(
    val id:Int?,
    @Json(name = "original_title") val title: String?,
    val type: String?,
    @Json(name = "runtime_minutes") val runtimeMinutes: Int?,
    val year: Int?,
    @Json(name = "release_date") val releaseDate: String?,
    val poster: String?,
    val trailer: String?
)

@Serializable
data class MovieDetails(
    val id:Int?,
    @SerialName("original_title") val title: String?,
    val type: String?,
    @SerialName("runtime_minutes") val runtimeMinutes: Int?,
    val year: Int?,
    @SerialName("release_date") val releaseDate: String?,
    val poster: String?,
    val trailer: String?

)