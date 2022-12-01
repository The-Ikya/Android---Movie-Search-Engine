package com.technipixl.eval5.ui.state

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.technipixl.eval5.MovieResult
import com.technipixl.eval5.model.NavigationRoutes
import com.technipixl.eval5.ui.SearchMovieScreen
import com.technipixl.eval5.ui.viewModels.PopularMoviesViewModel
import com.technipixl.eval5.ui.viewModels.SearchMoviesViewModel

class NavigationState(private val navController: NavHostController) {
	val topLevelScreens = NavigationRoutes.TopLevelScreens.values()
	val deepLevelScreens = NavigationRoutes.DeepLevelScreens.values()

	var currentScreen: String = NavigationRoutes.TopLevelScreens.Search.name

	lateinit var searchViewModel: SearchMoviesViewModel
	lateinit var popularViewModel: PopularMoviesViewModel

	@Composable
	fun InitNavigation() {
		val backStackEntry by navController.currentBackStackEntryAsState()
		currentScreen = backStackEntry?.destination?.route
			?: NavigationRoutes.TopLevelScreens.Search.name
		searchViewModel = viewModel()
		popularViewModel = viewModel()
	}

	@OptIn(ExperimentalMaterial3Api::class)
	@Composable
	fun AppNavigation() {
		Scaffold(
			topBar = {},
			bottomBar = {}
		) { innerPadding ->
			var selectedMovie by remember { mutableStateOf<MovieResult.Movie?>(null) }

			NavHost(
				navController = navController,
				startDestination = currentScreen,
				modifier = Modifier.padding(innerPadding)
			) {
				composable(route = NavigationRoutes.TopLevelScreens.Search.name) {
					SearchMovieScreen(
						onClick = {
							selectedMovie = it
							navController.navigate(NavigationRoutes.DeepLevelScreens.Details.name) {
								popUpTo(NavigationRoutes.TopLevelScreens.Search.name) {
									saveState = true
								}
								launchSingleTop = true
								restoreState = true
							}
						},
						viewModel = searchViewModel
					)
					currentScreen = NavigationRoutes.TopLevelScreens.Search.name
				}

				
			}
		}
	}
}