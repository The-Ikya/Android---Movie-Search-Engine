package com.technipixl.eval5.ui

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.technipixl.eval5.model.NavigationRoutes
import com.technipixl.eval5.ui.theme.Eval5Theme

@Composable
fun BottomNavigationBar(
	modifier: Modifier = Modifier,
	selected: NavigationRoutes.TopLevelScreens,
	onNavigationChanged: (NavigationRoutes.TopLevelScreens) -> Unit
) {
	BottomNavigation(
		modifier = modifier
	) {
		BottomNavigationItem(
			selected = selected == NavigationRoutes.TopLevelScreens.Search,
			onClick = { onNavigationChanged(NavigationRoutes.TopLevelScreens.Search) },
			icon = {
				if (selected == NavigationRoutes.TopLevelScreens.Search)
					Icon(
						imageVector = selected.selectedIcon,
						contentDescription = selected.name
					)
				else
					Icon(
						imageVector = NavigationRoutes.TopLevelScreens.Search.unselectedIcon,
						contentDescription = NavigationRoutes.TopLevelScreens.Search.name
					)
			},
			label = {
				Text(NavigationRoutes.TopLevelScreens.Search.name)
			}
		)
		BottomNavigationItem(
			selected = selected == NavigationRoutes.TopLevelScreens.Popular,
			onClick = { onNavigationChanged(NavigationRoutes.TopLevelScreens.Popular) },
			icon = {
				if (selected == NavigationRoutes.TopLevelScreens.Popular)
					Icon(
						imageVector = selected.selectedIcon,
						contentDescription = selected.name
					)
				else
					Icon(
						imageVector = NavigationRoutes.TopLevelScreens.Popular.unselectedIcon,
						contentDescription = NavigationRoutes.TopLevelScreens.Popular.name
					)
			},
			label = {
				Text(NavigationRoutes.TopLevelScreens.Popular.name)
			}
		)
	}
}

@Composable
@Preview
fun BottomNavBarPreviewSearch() {
	Eval5Theme {
		BottomNavigationBar(
			selected = NavigationRoutes.TopLevelScreens.Search,
			onNavigationChanged = {}
		)
	}
}

@Composable
@Preview
fun BottomNavBarPreviewPopular() {
	Eval5Theme {
		BottomNavigationBar(
			selected = NavigationRoutes.TopLevelScreens.Popular,
			onNavigationChanged = {}
		)
	}
}