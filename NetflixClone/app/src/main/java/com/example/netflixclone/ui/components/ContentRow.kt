package com.example.netflixclone.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.netflixclone.data.model.CollectionLayout
import com.example.netflixclone.data.model.Content
import com.example.netflixclone.data.model.ContentCollection

@Composable
fun ContentRow(
    collection: ContentCollection,
    modifier: Modifier = Modifier,
    onContentClick: (Content) -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {
        SectionHeader(
            title = collection.title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 16.dp)
        ) {
            itemsIndexed(collection.items) { index, item ->
                when (collection.layout) {
                    CollectionLayout.Portrait ->
                        PortraitPosterCard(
                            imageUrl = item.posterUrl,
                            modifier = Modifier
                                .size(width = 120.dp, height = 180.dp)
                                .clickable { onContentClick(item) },
                            showGradientOverlay = false
                        )

                    CollectionLayout.Landscape ->
                        LandscapePosterCard(
                            imageUrl = item.backdropUrl,
                            modifier = Modifier
                                .size(width = 220.dp, height = 120.dp)
                                .clickable { onContentClick(item) }
                        )

                    CollectionLayout.Spotlight ->
                        PortraitPosterCard(
                            imageUrl = item.posterUrl,
                            modifier = Modifier
                                .size(width = 160.dp, height = 240.dp)
                                .clickable { onContentClick(item) },
                            showGradientOverlay = true
                        )
                }
                if (collection.showRanking) {
                    RankingBadge(position = index + 1)
                }
            }
        }
    }
}

@Composable
private fun RankingBadge(position: Int) {
    Box(
        modifier = Modifier
            .padding(start = 8.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Text(
            text = position.toString(),
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White
        )
    }
}