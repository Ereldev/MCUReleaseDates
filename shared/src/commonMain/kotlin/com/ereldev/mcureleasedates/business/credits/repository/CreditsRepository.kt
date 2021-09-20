package com.ereldev.mcureleasedates.business.credits.repository

import com.ereldev.mcureleasedates.business.credits.api.CreditsApi
import com.ereldev.mcureleasedates.business.credits.mapper.CreditsDtoToCreditsMapper
import com.ereldev.mcureleasedates.business.credits.model.Credits
import com.ereldev.mcureleasedates.business.show.model.Show

class CreditsRepository(
    private val api: CreditsApi,
    private val mapper: CreditsDtoToCreditsMapper
) {

    suspend fun getCredits(show: Show): Credits =
        mapper.from(api.getCredits(show))

}