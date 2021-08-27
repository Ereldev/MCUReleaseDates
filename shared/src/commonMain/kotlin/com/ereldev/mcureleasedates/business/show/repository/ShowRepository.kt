package com.ereldev.mcureleasedates.business.show.repository

import com.ereldev.mcureleasedates.business.show.api.ShowApi
import com.ereldev.mcureleasedates.business.show.model.Show

class ShowRepository(
    private val api: ShowApi
) {

    // TODO Add mapper
    suspend fun getMovies(): List<Show> =
        api.getMovies().results.map {
            Show(it.originalTitle ?: "")
        }

    suspend fun getTVShows() =
        api.getTVShows()

}