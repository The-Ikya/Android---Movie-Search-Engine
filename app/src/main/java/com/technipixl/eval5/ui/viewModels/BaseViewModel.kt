package com.technipixl.eval5.ui.viewModels

import androidx.lifecycle.ViewModel
import com.technipixl.eval5.MovieResult
import com.technipixl.eval5.network.BaseAPI
import kotlinx.coroutines.flow.MutableSharedFlow

abstract class BaseViewModel : ViewModel() {
	abstract val service: BaseAPI
	var movieList = MutableSharedFlow<List<MovieResult.Movie>>()

	abstract suspend fun fillMovieList()
}