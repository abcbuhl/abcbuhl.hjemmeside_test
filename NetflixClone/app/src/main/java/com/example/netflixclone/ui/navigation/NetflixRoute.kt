package com.example.netflixclone.ui.navigation

sealed class NetflixRoute(val route: String) {
    data object Splash : NetflixRoute("splash")
    data object SignIn : NetflixRoute("sign_in")
    data object Profile : NetflixRoute("profile")
    data object Home : NetflixRoute("home")
    data object Details : NetflixRoute("details/{contentId}") {
        const val ARG_CONTENT_ID = "contentId"
        fun create(contentId: String) = "details/$contentId"
    }
    data object Search : NetflixRoute("search")
    data object ComingSoon : NetflixRoute("coming_soon")
    data object Downloads : NetflixRoute("downloads")
}