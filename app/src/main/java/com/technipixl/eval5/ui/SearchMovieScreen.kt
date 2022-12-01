package com.technipixl.eval5.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.technipixl.eval5.MovieResult
import com.technipixl.eval5.ui.viewModels.SearchMoviesViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.technipixl.eval5.network.BASE_IMG_URL

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchMovieHeader(
	modifier: Modifier = Modifier,
	viewModel: SearchMoviesViewModel = viewModel()
) {
	var textState by remember { mutableStateOf("") }
	var searchBarState by remember { mutableStateOf(false) }

	Box(
		modifier = modifier
			.background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(20.dp))
	) {
		Row(
			modifier = Modifier
				.padding(10.dp)
				.padding(top = 5.dp)
		) {
			if (searchBarState) {
				Text(
					text = "Search",
					fontSize = 30.sp,
					fontWeight = FontWeight.Bold,
					color = Color.White
				)
				IconToggleButton(
					checked = searchBarState,
					onCheckedChange = { searchBarState = !searchBarState }
				) {
					Icon(
						imageVector = Icons.Filled.Search,
						contentDescription = null
					)
				}
			}
			else {
				TextField(
					value = textState,
					onValueChange = {
						textState = it
						viewModel.searchMovie(it)
					},
					placeholder = {
						Text(text = "Search")
					},
					leadingIcon = {
						Icon(
							imageVector = Icons.Filled.Search,
							contentDescription = null
						)
					}
				)
			}
		}
	}
}

@Composable
fun SearchMovieScreen(
	modifier: Modifier = Modifier,
	onClick: (MovieResult.Movie) -> Unit,
	viewModel: SearchMoviesViewModel = viewModel()
) {
	val movies by viewModel.movieList.collectAsState(initial = listOf())

	LazyColumn(
		modifier = modifier
	) {
		items(movies) { movie ->
			SearchMovieCell(
				movie = movie,
				modifier = Modifier
					.padding(8.dp)
					.clickable {
						onClick(movie)
					}
			)
			Divider()
		}
	}
}

@Composable
fun SearchMovieCell(
	modifier: Modifier = Modifier,
	movie: MovieResult.Movie
) {
	Row(
		modifier = modifier
	) {
		Image(
			modifier = Modifier
				.fillMaxWidth(0.20f)
				.height(100.dp),
			painter = rememberAsyncImagePainter("$BASE_IMG_URL${movie.posterPath}"),
			contentDescription = movie.name,
			contentScale = ContentScale.FillBounds
		)
		Column {
			movie.title?.let {
				Text(
					text = it,
					fontWeight = FontWeight.Bold
				)
			}
			movie.releaseDate?.let {
				Text(it)
			}
		}
	}
}

@Composable
@Preview
fun SearchMovieHeaderPreview() {
	SearchMovieHeader()
}

@Composable
@Preview
fun SearchMovieScreenPreview() {
	SearchMovieScreen(onClick = {})
}
