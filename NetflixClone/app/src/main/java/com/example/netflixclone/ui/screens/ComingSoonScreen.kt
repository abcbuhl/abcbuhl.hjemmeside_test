package com.example.netflixclone.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import com.example.netflixclone.ui.preview.PreviewData
import com.example.netflixclone.ui.theme.NetflixCloneTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.netflixclone.data.model.ComingSoonItem

@Composable
fun ComingSoonScreen(
    items: List<ComingSoonItem>,
    onItemSelected: (ComingSoonItem) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item {
            Text(
                text = "Coming Soon",
                modifier = Modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        items(items, key = { it.id }) { item ->
            ComingSoonCard(item = item, onItemSelected = onItemSelected)
        }
    }
}

@Composable
private fun ComingSoonCard(item: ComingSoonItem, onItemSelected: (ComingSoonItem) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        AsyncImage(
            model = item.content.backdropUrl,
            contentDescription = item.content.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = item.releaseDate, color = Color.Gray)
                    Text(
                        text = item.content.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    IconButton(onClick = { /* Reminder toggled */ }) {
                        Icon(Icons.Outlined.Notifications, contentDescription = "Remind Me", tint = Color.White)
                    }
                    IconButton(onClick = { onItemSelected(item) }) {
                        Icon(Icons.Outlined.Info, contentDescription = "Info", tint = Color.White)
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = item.content.description, color = Color.White.copy(alpha = 0.85f))
        }
    }
}
