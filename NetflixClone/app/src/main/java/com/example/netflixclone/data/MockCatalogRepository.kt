package com.example.netflixclone.data

import com.example.netflixclone.data.model.CollectionLayout
import com.example.netflixclone.data.model.ComingSoonItem
import com.example.netflixclone.data.model.Content
import com.example.netflixclone.data.model.ContentCollection
import com.example.netflixclone.data.model.DownloadItem
import com.example.netflixclone.data.model.UserProfile

class MockCatalogRepository {

    private val masterCatalog = listOf(
        Content(
            id = "stranger-things",
            title = "Stranger Things",
            description = "A group of young friends witness supernatural forces and secret government exploits in 1980s Indiana.",
            releaseYear = 2019,
            ageRating = "16+",
            duration = "4 Seasons",
            categories = listOf("Sci-Fi", "Mystery", "Teen", "Drama"),
            posterUrl = "https://image.tmdb.org/t/p/w500/x2LSRK2Cm7MZhjluni1msVJ3wDF.jpg",
            backdropUrl = "https://image.tmdb.org/t/p/original/iFn9ndr3XMwJYvFgb9mI7zZD0Mf.jpg",
            isTrending = true,
            isNetflixOriginal = true,
            isTop10 = true
        ),
        Content(
            id = "the-witcher",
            title = "The Witcher",
            description = "Geralt of Rivia, a mutated monster-hunter for hire, journeys toward his destiny in a turbulent world.",
            releaseYear = 2023,
            ageRating = "18+",
            duration = "3 Seasons",
            categories = listOf("Fantasy", "Action", "Drama"),
            posterUrl = "https://image.tmdb.org/t/p/w500/7vjaCdMw15FEbXyLQTVa04URsPm.jpg",
            backdropUrl = "https://image.tmdb.org/t/p/original/zV0wOZ7YuoEoTP0gxJv1nP9WLMv.jpg",
            isTrending = true,
            isNetflixOriginal = true
        ),
        Content(
            id = "money-heist",
            title = "Money Heist",
            description = "Eight thieves take hostages as part of their daring plan to print billions of euros in Spain's Royal Mint.",
            releaseYear = 2021,
            ageRating = "16+",
            duration = "5 Parts",
            categories = listOf("Thriller", "Drama", "Heist"),
            posterUrl = "https://image.tmdb.org/t/p/w500/reEMJA1uzscCbkpeRJeTT2bjqUp.jpg",
            backdropUrl = "https://image.tmdb.org/t/p/original/htjj34Bo3BR0WjSP4B8eBQYApdC.jpg",
            isTop10 = true,
            isTrending = true
        ),
        Content(
            id = "bridgerton",
            title = "Bridgerton",
            description = "Wealth, lust, and betrayal set in the backdrop of Regency era England.",
            releaseYear = 2024,
            ageRating = "16+",
            duration = "3 Seasons",
            categories = listOf("Romance", "Drama", "Period"),
            posterUrl = "https://image.tmdb.org/t/p/w500/dY5KM0hgDyPV5YwY7VJHF6JKQ6N.jpg",
            backdropUrl = "https://image.tmdb.org/t/p/original/w2v6bZ8lJo7KdJ9Yt6Cuu2DalvR.jpg"
        ),
        Content(
            id = "dark",
            title = "Dark",
            description = "A missing child sets four families on a frantic hunt for answers as they unearth a mind-bending mystery.",
            releaseYear = 2020,
            ageRating = "16+",
            duration = "3 Seasons",
            categories = listOf("Mystery", "Thriller", "Sci-Fi"),
            posterUrl = "https://image.tmdb.org/t/p/w500/apbrbWs8M9lyOpJYU5WXrpFbk1Z.jpg",
            backdropUrl = "https://image.tmdb.org/t/p/original/rXsh4MI6uyVgZBSSzXCfitJnVPy.jpg",
            isTrending = true
        ),
        Content(
            id = "squid-game",
            title = "Squid Game",
            description = "Hundreds of cash-strapped players accept an invitation to compete in children's games for a tempting prize.",
            releaseYear = 2021,
            ageRating = "18+",
            duration = "1 Season",
            categories = listOf("Thriller", "Survival", "Drama"),
            posterUrl = "https://image.tmdb.org/t/p/w500/dDlEmu3EZ0Pgg93K2SVNLCjCSvE.jpg",
            backdropUrl = "https://image.tmdb.org/t/p/original/oaGvjBVMUgKIXJYy9M34vOPuYGY.jpg",
            isTop10 = true
        ),
        Content(
            id = "lupin",
            title = "Lupin",
            description = "Inspired by the adventures of Arsene Lupin, gentleman thief Assane Diop sets out to avenge his father.",
            releaseYear = 2023,
            ageRating = "13+",
            duration = "3 Parts",
            categories = listOf("Thriller", "Heist", "French"),
            posterUrl = "https://image.tmdb.org/t/p/w500/sgH4QWvR1SfIhlZr4KKLk8ENEcQ.jpg",
            backdropUrl = "https://image.tmdb.org/t/p/original/s9h1PzupwnvK2cYOPkWAM5dUv2U.jpg"
        ),
        Content(
            id = "all-of-us-are-dead",
            title = "All of Us Are Dead",
            description = "A high school becomes ground zero for a zombie virus outbreak.",
            releaseYear = 2022,
            ageRating = "18+",
            duration = "1 Season",
            categories = listOf("Horror", "Zombie", "Teen"),
            posterUrl = "https://image.tmdb.org/t/p/w500/4ljvdHqbnrB3o1RAizqXbMx64I0.jpg",
            backdropUrl = "https://image.tmdb.org/t/p/original/t5zCBSB5EXYPeUy99I0KzsZVb1N.jpg",
            isTop10 = true
        ),
        Content(
            id = "queen-gambit",
            title = "The Queen's Gambit",
            description = "In the 1950s, a young orphan discovers her astonishing talent for chess.",
            releaseYear = 2020,
            ageRating = "16+",
            duration = "Limited Series",
            categories = listOf("Drama", "Period", "Sports"),
            posterUrl = "https://image.tmdb.org/t/p/w500/zU0htwkhNvBQdVSIKB9s6hgVeFK.jpg",
            backdropUrl = "https://image.tmdb.org/t/p/original/lZXp6vxTgk6kqlg6x0AzHgshPvd.jpg"
        ),
        Content(
            id = "ozark",
            title = "Ozark",
            description = "A financial adviser drags his family from Chicago to the Missouri Ozarks, where he launders money.",
            releaseYear = 2022,
            ageRating = "18+",
            duration = "4 Seasons",
            categories = listOf("Crime", "Drama", "Thriller"),
            posterUrl = "https://image.tmdb.org/t/p/w500/peJsDWMpCDvDX7wd4Ih9p2j0Ad2.jpg",
            backdropUrl = "https://image.tmdb.org/t/p/original/9bW1GOSlH3fiYQzdBmiEYDHHP76.jpg"
        ),
        Content(
            id = "narcos",
            title = "Narcos",
            description = "The rise of the cocaine trade in Colombia and the gripping stories of drug kingpins.",
            releaseYear = 2017,
            ageRating = "18+",
            duration = "3 Seasons",
            categories = listOf("Crime", "Drama", "Biography"),
            posterUrl = "https://image.tmdb.org/t/p/w500/rTmal9fDbwh5F0waol2hq35U4ah.jpg",
            backdropUrl = "https://image.tmdb.org/t/p/original/sYdP1f0NenE2noKGbbgRIFk0UqT.jpg"
        )
    )

    private val curatedCollections = listOf(
        ContentCollection(
            id = "continue-watching",
            title = "Continue Watching for You",
            items = masterCatalog.shuffled().take(7),
            layout = CollectionLayout.Landscape
        ),
        ContentCollection(
            id = "trending-now",
            title = "Trending Now",
            items = masterCatalog.filter { it.isTrending } + masterCatalog.take(3),
            layout = CollectionLayout.Portrait
        ),
        ContentCollection(
            id = "top-10",
            title = "Top 10 TV Shows Today",
            items = masterCatalog.filter { it.isTop10 },
            layout = CollectionLayout.Portrait,
            showRanking = true
        ),
        ContentCollection(
            id = "netflix-originals",
            title = "Netflix Originals",
            items = masterCatalog.filter { it.isNetflixOriginal } + masterCatalog.shuffled().take(3),
            layout = CollectionLayout.Spotlight
        ),
        ContentCollection(
            id = "because-you-watched",
            title = "Because You Watched Sci-Fi",
            items = masterCatalog.filter { "Sci-Fi" in it.categories }.ifEmpty { masterCatalog.take(5) },
            layout = CollectionLayout.Portrait
        )
    )

    private val comingSoon = listOf(
        ComingSoonItem(
            id = "soon-rebel-moon",
            content = masterCatalog.first { it.id == "stranger-things" },
            releaseDate = "November 17",
            hasReminder = true
        ),
        ComingSoonItem(
            id = "soon-live-action",
            content = masterCatalog.first { it.id == "the-witcher" },
            releaseDate = "December 5"
        ),
        ComingSoonItem(
            id = "soon-heist",
            content = masterCatalog.first { it.id == "money-heist" },
            releaseDate = "Coming Next Year"
        )
    )

    private val downloads = listOf(
        DownloadItem(
            id = "download-dark",
            content = masterCatalog.first { it.id == "dark" },
            downloadQuality = "High",
            fileSizeGb = 1.4,
            downloaded = true
        ),
        DownloadItem(
            id = "download-queen",
            content = masterCatalog.first { it.id == "queen-gambit" },
            downloadQuality = "Standard",
            fileSizeGb = 0.9,
            downloaded = false
        )
    )

    private val profiles = listOf(
        UserProfile(id = "1", name = "Alex", avatarColor = 0xFFE50914),
        UserProfile(id = "2", name = "Taylor", avatarColor = 0xFF1F8A70),
        UserProfile(id = "3", name = "Morgan", avatarColor = 0xFFB81D24),
        UserProfile(id = "4", name = "Guest", avatarColor = 0xFF0F4C81)
    )

    fun heroContent(): Content = masterCatalog.first()

    fun contentCollections(): List<ContentCollection> = curatedCollections

    fun findContentById(id: String): Content? = masterCatalog.find { it.id == id }

    fun search(query: String): List<Content> =
        if (query.isBlank()) emptyList()
        else masterCatalog.filter {
            it.title.contains(query, ignoreCase = true) ||
                it.categories.any { category -> category.contains(query, ignoreCase = true) }
        }

    fun comingSoonItems(): List<ComingSoonItem> = comingSoon

    fun downloadItems(): List<DownloadItem> = downloads

    fun userProfiles(): List<UserProfile> = profiles

    fun trendingNow(): List<Content> = masterCatalog.filter { it.isTrending }

    fun topTenToday(): List<Content> = masterCatalog.filter { it.isTop10 }
}
