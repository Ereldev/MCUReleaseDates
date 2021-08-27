package com.ereldev.mcureleasedates.business.show

import com.ereldev.mcureleasedates.business.show.model.Shows
import com.ereldev.mcureleasedates.business.show.repository.ShowRepository

class GetShowsUseCase(
    private val showRepository: ShowRepository
) {

    suspend fun execute() = Shows(
        showRepository.getMovies(),
        showRepository.getTVShows()
    )

}