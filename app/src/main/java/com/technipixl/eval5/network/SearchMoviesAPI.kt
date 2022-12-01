package com.technipixl.eval5.network

import com.technipixl.eval5.MovieResult
import retrofit2.http.GET
import retrofit2.http.Query

class SearchMoviesAPI : BaseAPI() {
	interface SearchMovieRoute {
		@GET("search/movie")
		suspend fun searchMovie(
			@Query("page") page: Int,
			@Query("query") query: String,
			@Query("api_key") apiKey: String,
			@Query("language") language: String
		) : MovieResult
	}

	suspend fun getMoviesFromQuery(
		page: Int,
		query: String,
		apiKey: String = API_KEY,
		language: String = "fr"
	) = retrofit.create(SearchMovieRoute::class.java)
		.searchMovie(page, query, apiKey, language).results ?: listOf()
}