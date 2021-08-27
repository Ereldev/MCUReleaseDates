package com.ereldev.mcureleasedates.business.show.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShowDto(
    val id: Int,
    @SerialName("original_title") val originalTitle: String?
)