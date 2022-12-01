package com.technipixl.eval5.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RatingCircle(
	modifier: Modifier = Modifier,
	rating: @Composable () -> Unit
) {
	Column(
		modifier = modifier
			.fillMaxWidth()
			.padding(10.dp),
		horizontalAlignment = Alignment.End
	) {
		Box(
			modifier = Modifier
				.clip(CircleShape)
				.background(Color.White)
				.border(2.dp, MaterialTheme.colors.primary, shape = CircleShape),
			contentAlignment = Alignment.Center
		) {
			rating()
		}
	}
}
