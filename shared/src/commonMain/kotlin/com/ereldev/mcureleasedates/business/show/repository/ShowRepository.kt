package com.ereldev.mcureleasedates.business.show.repository

import com.ereldev.mcureleasedates.business.show.api.ShowApi
import com.ereldev.mcureleasedates.business.show.mapper.MovieDtoToShowMapper
import com.ereldev.mcureleasedates.business.show.mapper.TVShowDtoToShowMapper
import com.ereldev.mcureleasedates.business.show.model.Show

class ShowRepository(
    private val api: ShowApi,
    private val movieMapper: MovieDtoToShowMapper,
    private val tvShowMapper: TVShowDtoToShowMapper
) {

    suspend fun getMovies(): List<Show> =
        api.getMovies().results.map {
            movieMapper.from(it)
        }

    suspend fun getTVShows() =
        api.getTVShows().results.map {
            tvShowMapper.from(it)
        }

}