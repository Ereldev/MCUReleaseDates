package com.ereldev.mcureleasedates.business.show.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDto(
    val id: Int,
    @SerialName("original_title") val originalTitle: String? = null
)

@Serializable
data class TVShowDto(
    val id: Int,
    @SerialName("original_name") val originalName: String? = null
)