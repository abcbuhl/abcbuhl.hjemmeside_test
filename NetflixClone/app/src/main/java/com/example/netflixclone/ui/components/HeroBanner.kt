package com.example.netflixclone.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.matchParentSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
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
import com.example.netflixclone.ui.theme.NetflixRed

@Composable
fun HeroBanner(
    content: Content,
    modifier: Modifier = Modifier,
    onPlayClick: () -> Unit = {},
    onInfoClick: () -> Unit = {},
    onAddToList: () -> Unit = {}
) {
    Box(modifier = modifier.fillMaxWidth()) {
        AsyncImage(
            model = content.backdropUrl,
            contentDescription = content.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(460.dp),
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .padding(horizontal = 24.dp, vertical = 32.dp)
        ) {
            if (content.isNetflixOriginal) {
                Text(
                    text = "NETFLIX ORIGINAL",
                    color = NetflixRed,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            Text(
                text = content.title,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                style = androidx.compose.material3.MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "${content.releaseYear}", color = Color.White)
                Text(text = content.ageRating, color = Color.White)
                Text(text = content.duration, color = Color.White)
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = content.description,
                color = Color.White.copy(alpha = 0.85f)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = onPlayClick,
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Icon(
                        imageVector = Icons.Filled.PlayArrow,
                        contentDescription = null,
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(text = "Play", color = Color.Black)
                }
                OutlinedButton(
                    onClick = onInfoClick,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Icon(imageVector = Icons.Filled.Info, contentDescription = null)
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(text = "More Info")
                }
                FilledIconButton(
                    onClick = onAddToList,
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Icon(imageVector = Icons.Outlined.Check, contentDescription = "My List")
                }
            }
        }
    }
}