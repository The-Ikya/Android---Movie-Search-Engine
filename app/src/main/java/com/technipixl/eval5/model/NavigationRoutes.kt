package com.technipixl.eval5.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import com.technipixl.eval5.ui.viewModels.BaseViewModel

sealed class NavigationRoutes {
	enum class TopLevelScreens(
		val unselectedIcon: ImageVector,
		val selectedIcon: ImageVector,
	) {
		Popular(
			unselectedIcon = Icons.Outlined.Favorite,
			selectedIcon = Icons.Filled.Favorite,
		),
		Search(
			unselectedIcon = Icons.Outlined.Search,
			selectedIcon = Icons.Filled.Search
		)
	}
	enum class DeepLevelScreens {
		Details
	}
}
