package com.technipixl.eval5.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_IMG_URL = "https://image.tmdb.org/t/p/w500/"

abstract class BaseAPI {
	private val BASE_URL = "https://api.themoviedb.org/3/"
	val API_KEY = "b2168bae3a2c67509eb6b97572f521c2"

	val retrofit = Retrofit.Builder()
		.baseUrl(BASE_URL)
		.addConverterFactory(GsonConverterFactory.create())
		.build()
}