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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.netflixclone.data.model.Content
import com.example.netflixclone.ui.components.CategoryChips
import com.example.netflixclone.ui.components.PortraitPosterCard
import com.example.netflixclone.ui.theme.NetflixRed

@Composable
fun DetailsScreen(
    content: Content,
    recommended: List<Content>,
    onBack: () -> Unit,
    onPlay: () -> Unit,
    onDownload: () -> Unit,
    onAddToList: () -> Unit,
    onShare: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Box {
            AsyncImage(
                model = content.backdropUrl,
                contentDescription = content.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black)
                        )
                    )
            )
            IconButton(
                onClick = onBack,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopStart)
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = content.title,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "${content.releaseYear}", color = Color.LightGray)
                Text(text = content.ageRating, color = Color.LightGray)
                Text(text = content.duration, color = Color.LightGray)
            }
            Spacer(modifier = Modifier.height(12.dp))
            ElevatedButton(
                onClick = onPlay,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.elevatedButtonColors(containerColor = NetflixRed)
            ) {
                Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Play", color = Color.White)
            }
            Spacer(modifier = Modifier.height(12.dp))
            ElevatedButton(
                onClick = onDownload,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.elevatedButtonColors(containerColor = Color.DarkGray)
            ) {
                Icon(imageVector = Icons.Filled.Download, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Download", color = Color.White)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = content.description, color = Color.White.copy(alpha = 0.9f))
            Spacer(modifier = Modifier.height(16.dp))
            CategoryChips(categories = content.categories)
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                DetailIconAction(icon = Icons.Filled.Add, label = "My List", onClick = onAddToList)
                DetailIconAction(icon = Icons.Filled.ThumbUp, label = "Rate", onClick = { })
                DetailIconAction(icon = Icons.Outlined.Share, label = "Share", onClick = onShare)
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "More Like This",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(12.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(recommended, key = { it.id }) { item ->
                    PortraitPosterCard(
                        imageUrl = item.posterUrl,
                        modifier = Modifier.height(180.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(48.dp))
        }
    }
}

@Composable
private fun DetailIconAction(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    onClick: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(onClick = onClick) {
            Icon(imageVector = icon, contentDescription = label, tint = Color.White)
        }
        Text(text = label, color = Color.White, style = MaterialTheme.typography.bodySmall)
    }
}