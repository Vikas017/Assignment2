package com.android.movie.repo.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://api.watchmode.com/v1/"
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val kotlinxCinverterFactory = Json.asConverterFactory("application/json".toMediaType())

val RetrofitProvider = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
