package com.example.netflixclone.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = NetflixRed,
    onPrimary = Color.White,
    secondary = NetflixGray,
    onSecondary = Color.White,
    tertiary = NetflixOffWhite,
    background = NetflixDark,
    onBackground = Color.White,
    surface = NetflixDark,
    onSurface = Color.White,
    surfaceVariant = NetflixBackdrop,
    onSurfaceVariant = NetflixGray
)

@Composable
fun NetflixCloneTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}