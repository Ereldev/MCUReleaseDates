package com.ereldev.mcureleasedates.business.show.repository

import com.ereldev.mcureleasedates.business.common.DateUtils
import com.ereldev.mcureleasedates.business.show.api.ShowApi
import com.ereldev.mcureleasedates.business.show.mapper.MovieDtoToShowMapper
import com.ereldev.mcureleasedates.business.show.mapper.TVShowDtoToShowMapper
import com.ereldev.mcureleasedates.business.show.model.Show

class ShowRepository(
    private val api: ShowApi,
    private val movieMapper: MovieDtoToShowMapper,
    private val tvShowMapper: TVShowDtoToShowMapper
) {

    suspend fun getMovies(keyword: String): List<Show> =
        api.getMovies(keyword).results
            // API returns certain shows even if date is passed
            .filter { (it.releaseDate != null && it.releaseDate >= DateUtils.nowMinusOneMonth()) }
            .map { movieMapper.from(it) }

    suspend fun getTVShows(keyword: String) =
        api.getTVShows(keyword).results
            // API returns certain shows even if date is passed
            .filter { (it.firstAirDate != null && it.firstAirDate >= DateUtils.nowMinusOneMonth()) }
            .map { tvShowMapper.from(it) }

}