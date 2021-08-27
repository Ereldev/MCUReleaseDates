package com.ereldev.mcureleasedates.business.show.model

data class Shows(
    val movies: List<Show>,
    val tvShows: List<Show>
)

data class Show(
    val title: String
)