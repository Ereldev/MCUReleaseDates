package com.ereldev.mcureleasedates.business.show.model

import com.ereldev.mcureleasedates.business.common.Parcelize

data class Shows(
    val movies: List<Show>,
    val tvShows: List<Show>
)

data class Show(
    val id: Int,
    val title: String,
    val overview: String,
    val date: String,
    val image: String? = null,
    val background: String? = null
): Parcelize()