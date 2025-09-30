package com.example.netflixclone.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.derivedStateOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.netflixclone.data.MockCatalogRepository
import com.example.netflixclone.data.model.UserProfile
import com.example.netflixclone.ui.components.NetflixBottomNavigation
import com.example.netflixclone.ui.navigation.BottomNavigationDestinations
import com.example.netflixclone.ui.navigation.NetflixRoute
import com.example.netflixclone.ui.screens.ComingSoonScreen
import com.example.netflixclone.ui.screens.DetailsScreen
import com.example.netflixclone.ui.screens.DownloadsScreen
import com.example.netflixclone.ui.screens.HomeScreen
import com.example.netflixclone.ui.screens.ProfilePickerScreen
import com.example.netflixclone.ui.screens.SearchScreen
import com.example.netflixclone.ui.screens.SignInScreen
import com.example.netflixclone.ui.screens.SplashScreen

@Composable
fun NetflixCloneApp() {
    val navController = rememberNavController()
    val repository = remember { MockCatalogRepository() }
    var activeProfile by remember { mutableStateOf<UserProfile?>(null) }
    var searchQuery by rememberSaveable { mutableStateOf("") }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val showBottomBar by remember {
        derivedStateOf {
            BottomNavigationDestinations.any { destination ->
                currentRoute?.startsWith(destination.route) == true
            }
        }
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            if (showBottomBar) {
                NetflixBottomNavigation(currentRoute = currentRoute) { destination ->
                    navController.navigate(destination.route) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NetflixRoute.Splash.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(NetflixRoute.Splash.route) {
                SplashScreen(onFinished = {
                    navController.navigate(NetflixRoute.SignIn.route) {
                        popUpTo(NetflixRoute.Splash.route) { inclusive = true }
                    }
                })
            }
            composable(NetflixRoute.SignIn.route) {
                SignInScreen(onSignIn = {
                    navController.navigate(NetflixRoute.Profile.route) {
                        popUpTo(NetflixRoute.SignIn.route) { inclusive = true }
                    }
                })
            }
            composable(NetflixRoute.Profile.route) {
                ProfilePickerScreen(
                    profiles = repository.userProfiles(),
                    onProfileSelected = { profile ->
                        activeProfile = profile
                        navController.navigate(NetflixRoute.Home.route) {
                            popUpTo(NetflixRoute.Profile.route) { inclusive = true }
                        }
                    }
                )
            }
            composable(NetflixRoute.Home.route) {
                val profile = activeProfile ?: repository.userProfiles().first()
                HomeScreen(
                    selectedProfile = profile,
                    heroContent = repository.heroContent(),
                    collections = repository.contentCollections(),
                    onContentSelected = { content ->
                        navController.navigate(NetflixRoute.Details.create(content.id))
                    },
                    onSearchRequested = {
                        navController.navigate(NetflixRoute.Search.route)
                    },
                    onNotificationsClick = {
                        navController.navigate(NetflixRoute.ComingSoon.route)
                    }
                )
            }
            composable(NetflixRoute.Search.route) {
                val results = repository.search(searchQuery)
                SearchScreen(
                    query = searchQuery,
                    trending = repository.trendingNow(),
                    results = results,
                    onQueryChanged = { searchQuery = it },
                    onContentSelected = { content ->
                        navController.navigate(NetflixRoute.Details.create(content.id))
                    }
                )
            }
            composable(NetflixRoute.ComingSoon.route) {
                ComingSoonScreen(
                    items = repository.comingSoonItems(),
                    onItemSelected = { item ->
                        navController.navigate(NetflixRoute.Details.create(item.content.id))
                    }
                )
            }
            composable(NetflixRoute.Downloads.route) {
                DownloadsScreen(
                    items = repository.downloadItems(),
                    onExploreDownloads = {
                        navController.navigate(NetflixRoute.Home.route)
                    },
                    onPlayItem = { item ->
                        navController.navigate(NetflixRoute.Details.create(item.content.id))
                    }
                )
            }
            composable(
                route = NetflixRoute.Details.route,
                arguments = listOf(
                    navArgument(NetflixRoute.Details.ARG_CONTENT_ID) {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getString(NetflixRoute.Details.ARG_CONTENT_ID)
                val content = id?.let { repository.findContentById(it) }
                if (content == null) {
                    Text(text = "Content not found", color = MaterialTheme.colorScheme.onBackground)
                } else {
                    DetailsScreen(
                        content = content,
                        recommended = repository.contentCollections().firstOrNull()?.items.orEmpty(),
                        onBack = { navController.popBackStack() },
                        onPlay = { /* TODO: integrate player */ },
                        onDownload = { /* TODO: download action */ },
                        onAddToList = { /* TODO: add to list */ }
                    )
                }
            }
        }
    }
}
