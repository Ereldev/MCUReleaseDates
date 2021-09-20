package com.ereldev.mcureleasedates.business.credits.mapper

import com.ereldev.mcureleasedates.business.common.Mapper
import com.ereldev.mcureleasedates.business.credits.model.Actor
import com.ereldev.mcureleasedates.business.credits.model.Credits
import com.ereldev.mcureleasedates.business.credits.model.CreditsDto
import com.ereldev.mcureleasedates.business.show.api.ShowApi

class CreditsDtoToCreditsMapper: Mapper<CreditsDto, Credits>() {

    override fun from(from: CreditsDto) = Credits(
        from.cast
            .sortedBy { it.order }
            .map {
                Actor(
                    it.name ?: "",
                    it.character ?: "",
                    it.profilePath?.let { "${ShowApi.POSTER_URL}$it" }
                )
        }
    )

}