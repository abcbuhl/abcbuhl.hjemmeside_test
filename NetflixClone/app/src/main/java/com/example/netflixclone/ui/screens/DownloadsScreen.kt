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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DownloadDone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.netflixclone.data.model.DownloadItem
import com.example.netflixclone.ui.theme.NetflixRed

@Composable
fun DownloadsScreen(
    items: List<DownloadItem>,
    onExploreDownloads: () -> Unit,
    onPlayItem: (DownloadItem) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Text(
            text = "Downloads",
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(24.dp))
        if (items.isEmpty()) {
            EmptyDownloads(onExploreDownloads = onExploreDownloads)
        } else {
            items.forEach { item ->
                DownloadCard(item = item, onPlayItem = onPlayItem)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun EmptyDownloads(onExploreDownloads: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Filled.DownloadDone,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.height(72.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Movies and TV shows that you download appear here.",
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = onExploreDownloads,
            colors = ButtonDefaults.buttonColors(containerColor = NetflixRed)
        ) {
            Text(text = "Find Something to Download", color = Color.White)
        }
    }
}

@Composable
private fun DownloadCard(item: DownloadItem, onPlayItem: (DownloadItem) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray.copy(alpha = 0.3f), shape = RoundedCornerShape(12.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        AsyncImage(
            model = item.content.posterUrl,
            contentDescription = item.content.title,
            modifier = Modifier
                .height(120.dp)
                .width(90.dp),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(text = item.content.title, color = Color.White, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "${item.downloadQuality} • ${item.fileSizeGb} GB", color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { onPlayItem(item) },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.15f))
            ) {
                Text(text = if (item.downloaded) "Play" else "Download", color = Color.White)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun DownloadsScreenPreview() {
    val data = PreviewData
    NetflixCloneTheme {
        DownloadsScreen(
            items = data.downloads,
            onExploreDownloads = {},
            onPlayItem = {}
        )
    }
}
