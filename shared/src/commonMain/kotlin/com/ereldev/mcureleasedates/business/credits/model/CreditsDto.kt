package com.ereldev.mcureleasedates.business.credits.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreditsDto(
    val cast: List<ActorDto>
)

@Serializable
data class ActorDto(
    val name: String?,
    val character: String?,
    @SerialName("profile_path") val profilePath: String?,
    val order: Int
)