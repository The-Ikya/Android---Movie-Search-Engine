package com.technipixl.eval5.ui.viewModels

import androidx.lifecycle.viewModelScope
import com.technipixl.eval5.network.SearchMoviesAPI
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.launch

class SearchMoviesViewModel : BaseViewModel() {
	override val service = SearchMoviesAPI()

	private var currentSearch = ""
	private var currentPage = 1

	override suspend fun fillMovieList() {
		movieList.emit(service.getMoviesFromQuery(currentPage, currentSearch))
	}

	fun searchMovie(searchStr: String) {
		viewModelScope.launch {
			if (searchStr.trim().count() >= 3) {
				delay(1000)
				currentSearch = searchStr
			}
			else {
				movieList.emit(listOf())
			}
		}
	}
}