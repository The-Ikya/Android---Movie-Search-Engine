package com.technipixl.eval5.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.technipixl.eval5.MovieResult
import com.technipixl.eval5.network.BASE_IMG_URL
import com.technipixl.eval5.ui.theme.Eval5Theme
import com.technipixl.eval5.ui.viewModels.PopularMoviesViewModel

@Composable
@Preview
fun PopularMovieScreenHeader(
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier
			.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Text("Popular", fontWeight = FontWeight.Bold)
	}
}

@Composable
fun PopularMovieScreen(
	modifier: Modifier = Modifier,
	onClick: (MovieResult.Movie) -> Unit,
	viewModel: PopularMoviesViewModel = viewModel()
) {
	val movies by viewModel.movieList.collectAsState(initial = listOf())

	LazyVerticalGrid(columns = GridCells.Fixed(3)) {
		items(movies) { movie ->
			PopularMovieCell(
				modifier = Modifier.clickable { onClick(movie) },
				movie = movie
			)
		}
	}
}

@Composable
fun PopularMovieCell(
	modifier: Modifier = Modifier,
	movie: MovieResult.Movie
) {
	Card(
		modifier = modifier
			.fillMaxWidth()
			.fillMaxHeight(0.23f),
		shape = RoundedCornerShape(20),
		elevation = CardDefaults.cardElevation(2.dp)
	) {
		Image(
			painter = rememberAsyncImagePainter("$BASE_IMG_URL${movie.posterPath}"),
			contentDescription = movie.name,
			contentScale = ContentScale.FillBounds
		)
		RatingCircle(
			Modifier.size(35.dp)
		) {
			Text(
				text = String.format("%.1f", movie.voteAverage),
				fontSize = 12.sp
			)
		}
	}
}

@Composable
@Preview(showSystemUi = true)
fun PopularScreenPreview() {
	Eval5Theme {
		PopularMovieScreen(onClick = {})
	}
}
