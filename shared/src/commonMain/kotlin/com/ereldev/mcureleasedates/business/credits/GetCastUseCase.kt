package com.ereldev.mcureleasedates.business.credits

import com.ereldev.mcureleasedates.business.credits.repository.CreditsRepository
import com.ereldev.mcureleasedates.business.show.model.Show

class GetCastUseCase(
    private val repository: CreditsRepository
) {

    suspend fun execute(show: Show) =
        repository.getCredits(show).cast.take(MAX_ACTORS)

    companion object {
        private const val MAX_ACTORS = 10
    }

}