package com.example.netflixclone.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MovieCreation
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MovieCreation
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationDestination(
    val route: String,
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

val BottomNavigationDestinations = listOf(
    BottomNavigationDestination(
        route = NetflixRoute.Home.route,
        label = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    ),
    BottomNavigationDestination(
        route = NetflixRoute.Search.route,
        label = "Search",
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = Icons.Outlined.Search
    ),
    BottomNavigationDestination(
        route = NetflixRoute.ComingSoon.route,
        label = "Coming Soon",
        selectedIcon = Icons.Filled.MovieCreation,
        unselectedIcon = Icons.Outlined.MovieCreation
    ),
    BottomNavigationDestination(
        route = NetflixRoute.Downloads.route,
        label = "Downloads",
        selectedIcon = Icons.Filled.Download,
        unselectedIcon = Icons.Outlined.Download
    )
)