package com.example.netflixclone.data.model

data class Content(
    val id: String,
    val title: String,
    val description: String,
    val releaseYear: Int,
    val ageRating: String,
    val duration: String,
    val categories: List<String>,
    val posterUrl: String,
    val backdropUrl: String,
    val isTrending: Boolean = false,
    val isNetflixOriginal: Boolean = false,
    val isTop10: Boolean = false,
    val previewVideoUrl: String? = null
)

data class ContentCollection(
    val id: String,
    val title: String,
    val items: List<Content>,
    val layout: CollectionLayout = CollectionLayout.Portrait,
    val showRanking: Boolean = false
)

enum class CollectionLayout {
    Portrait,
    Landscape,
    Spotlight
}

data class UserProfile(
    val id: String,
    val name: String,
    val avatarColor: Long
)

data class ComingSoonItem(
    val id: String,
    val content: Content,
    val releaseDate: String,
    val audioDescription: Boolean = true,
    val hasReminder: Boolean = false
)

data class DownloadItem(
    val id: String,
    val content: Content,
    val downloadQuality: String,
    val fileSizeGb: Double,
    val downloaded: Boolean
)