package com.example.netflixclone.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.weight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cast
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.netflixclone.data.model.Content
import com.example.netflixclone.data.model.ContentCollection
import com.example.netflixclone.data.model.UserProfile
import com.example.netflixclone.ui.components.CategoryChips
import com.example.netflixclone.ui.components.ContentRow
import com.example.netflixclone.ui.components.HeroBanner

@Composable
fun HomeScreen(
    selectedProfile: UserProfile,
    heroContent: Content,
    collections: List<ContentCollection>,
    onContentSelected: (Content) -> Unit,
    onSearchRequested: () -> Unit,
    onNotificationsClick: () -> Unit = {}
) {
    val listState = rememberLazyListState()
    val isElevated by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0 || listState.firstVisibleItemScrollOffset > 120
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                HeroBanner(
                    content = heroContent,
                    onPlayClick = { onContentSelected(heroContent) },
                    onInfoClick = { onContentSelected(heroContent) }
                )
            }
            item {
                CategoryRow()
            }
            items(collections, key = { it.id }) { collection ->
                ContentRow(
                    collection = collection,
                    onContentClick = onContentSelected
                )
            }
            item { Spacer(modifier = Modifier.height(64.dp)) }
        }

        HomeTopBar(
            isSolidBackground = isElevated,
            onSearchRequested = onSearchRequested,
            onNotificationsClick = onNotificationsClick,
            profile = selectedProfile,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}

@Composable
private fun CategoryRow() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xCC000000), Color.Transparent)
                )
            )
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        CategoryChips(
            categories = listOf("TV Shows", "Movies", "Categories"),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun HomeTopBar(
    isSolidBackground: Boolean,
    onSearchRequested: () -> Unit,
    onNotificationsClick: () -> Unit,
    profile: UserProfile,
    modifier: Modifier = Modifier
) {
    val backgroundColor = if (isSolidBackground) Color.Black.copy(alpha = 0.92f) else Color.Transparent
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        color = backgroundColor,
        tonalElevation = if (isSolidBackground) 6.dp else 0.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "N",
                color = Color.Red,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(end = 16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = onSearchRequested) {
                Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search", tint = Color.White)
            }
            IconButton(onClick = { /* Cast */ }) {
                Icon(imageVector = Icons.Filled.Cast, contentDescription = "Cast", tint = Color.White)
            }
            IconButton(onClick = onNotificationsClick) {
                Icon(imageVector = Icons.Filled.Notifications, contentDescription = "Notifications", tint = Color.White)
            }
            Surface(
                color = Color(profile.avatarColor),
                shape = androidx.compose.foundation.shape.CircleShape,
                tonalElevation = 4.dp,
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = profile.name.take(1).uppercase(),
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
        }
    }
}