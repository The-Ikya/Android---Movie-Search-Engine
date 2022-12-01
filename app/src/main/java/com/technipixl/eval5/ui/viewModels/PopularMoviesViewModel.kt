package com.technipixl.eval5.ui.viewModels

import androidx.lifecycle.viewModelScope
import com.technipixl.eval5.network.PopularMoviesAPI
import kotlinx.coroutines.launch

class PopularMoviesViewModel : BaseViewModel() {
	override val service = PopularMoviesAPI()

	var currentPage = 1

	init {
		viewModelScope.launch {
			fillMovieList()
		}
	}

	override suspend fun fillMovieList() {
		movieList.emit(service.getTrendingMovies(currentPage))
	}

	fun getNextPage() {
		currentPage++
		viewModelScope.launch {
			fillMovieList()
		}
	}
}