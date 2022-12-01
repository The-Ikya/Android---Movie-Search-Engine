package com.technipixl.eval5.network

import com.technipixl.eval5.MovieResult
import retrofit2.http.GET
import retrofit2.http.Query

class PopularMoviesAPI : BaseAPI() {
	interface PopularMovieRoutes {
		@GET("trending/all/day")
		suspend fun trendingMovies(
			@Query("page") page: Int,
			@Query("api_key") apiKey: String,
			@Query("language") language: String
		) : MovieResult
	}

	suspend fun getTrendingMovies(
		page: Int,
		apiKey: String = API_KEY,
		language: String = "fr"
	) = retrofit.create(PopularMovieRoutes::class.java)
			.trendingMovies(page, apiKey, language).results ?: listOf()
}