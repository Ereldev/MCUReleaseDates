package com.ereldev.mcureleasedates.business.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseDto<T>(
    val results: T,
    val page: Int,
    @SerialName("total_pages") val pages: Int,
    @SerialName("total_results") val total: Int
)