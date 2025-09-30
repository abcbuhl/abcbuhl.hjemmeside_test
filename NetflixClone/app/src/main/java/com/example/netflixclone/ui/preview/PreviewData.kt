package com.example.netflixclone.ui.preview

import com.example.netflixclone.data.MockCatalogRepository
import com.example.netflixclone.data.model.Content
import com.example.netflixclone.data.model.DownloadItem
import com.example.netflixclone.data.model.UserProfile

object PreviewData {
    private val repository = MockCatalogRepository()
    val hero: Content = repository.heroContent()
    val collections = repository.contentCollections()
    val profile: UserProfile = repository.userProfiles().first()
    val sampleContent: Content = collections.first().items.first()
    val downloads: List<DownloadItem> = repository.downloadItems()
    val comingSoon = repository.comingSoonItems()
}
