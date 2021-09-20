package com.ereldev.mcureleasedates.business.credits.model

data class Credits(
    val cast: List<Actor>
)

data class Actor(
    val name: String,
    val character: String,
    val profilePath: String?
)