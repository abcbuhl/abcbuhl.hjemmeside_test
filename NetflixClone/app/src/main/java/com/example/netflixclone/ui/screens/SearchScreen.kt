package com.example.netflixclone.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.netflixclone.data.model.Content
import com.example.netflixclone.ui.theme.NetflixRed

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchScreen(
    query: String,
    trending: List<Content>,
    results: List<Content>,
    onQueryChanged: (String) -> Unit,
    onContentSelected: (Content) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = onQueryChanged,
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = { Icon(Icons.Outlined.Search, contentDescription = null) },
            placeholder = { Text(text = "Search for a show, movie, genre...", color = Color.Gray) },
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = NetflixRed,
                unfocusedBorderColor = Color.DarkGray,
                cursorColor = Color.White,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                placeholderColor = Color.Gray,
                containerColor = Color(0x33000000)
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (query.isEmpty()) {
            Text(
                text = "Top Searches",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(12.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(trending, key = { it.id }) { content ->
                    SearchGridItem(content = content, onContentSelected = onContentSelected)
                }
            }
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(results, key = { it.id }) { content ->
                    SearchResultRow(content = content, onContentSelected = onContentSelected)
                }
            }
        }
    }
}

@Composable
private fun SearchGridItem(content: Content, onContentSelected: (Content) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray.copy(alpha = 0.3f), shape = RoundedCornerShape(8.dp))
            .clickable { onContentSelected(content) }
            .padding(12.dp)
    ) {
        AsyncImage(
            model = content.posterUrl,
            contentDescription = content.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = content.title, color = Color.White, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun SearchResultRow(content: Content, onContentSelected: (Content) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray.copy(alpha = 0.25f), shape = RoundedCornerShape(8.dp))
            .clickable { onContentSelected(content) }
            .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        AsyncImage(
            model = content.posterUrl,
            contentDescription = content.title,
            modifier = Modifier
                .height(140.dp)
                .width(100.dp),
            contentScale = ContentScale.Crop
        )
        Column {
            Text(text = content.title, color = Color.White, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = content.categories.joinToString(), color = Color.Gray)
        }
    }
}